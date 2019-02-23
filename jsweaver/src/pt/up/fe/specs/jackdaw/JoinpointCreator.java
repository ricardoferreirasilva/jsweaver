package pt.up.fe.specs.jackdaw;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.AJackdawWeaverJoinPoint;
import pt.up.fe.specs.jackdaw.joinpoints.JsDeclarator;
import pt.up.fe.specs.jackdaw.joinpoints.JsFile;
import pt.up.fe.specs.jackdaw.joinpoints.JsGeneric;
import pt.up.fe.specs.jackdaw.joinpoints.JsProject;
import pt.up.fe.specs.jackdaw.joinpoints.expressions.JsCallExpression;
import pt.up.fe.specs.jackdaw.joinpoints.expressions.JsIdentifier;
import pt.up.fe.specs.jackdaw.joinpoints.expressions.JsLiteral;
import pt.up.fe.specs.jackdaw.joinpoints.expressions.JsMemberExpression;
import pt.up.fe.specs.jackdaw.joinpoints.statements.JsDeclaration;
import pt.up.fe.specs.jackdaw.joinpoints.statements.JsExpressionStatement;
import pt.up.fe.specs.jackdaw.joinpoints.statements.JsIfStatement;
import pt.up.fe.specs.util.SpecsLogs;

public class JoinpointCreator {

    private static final Map<String, Function<JsonObject, AJackdawWeaverJoinPoint>> MAPPINGS;
    static {
        MAPPINGS = new HashMap<>();
        MAPPINGS.put("Project", JsProject::new);
        MAPPINGS.put("Program", JsFile::new);
        MAPPINGS.put("VariableDeclaration", JsDeclaration::new);
        MAPPINGS.put("VariableDeclarator", JsDeclarator::new);
        MAPPINGS.put("Identifier", JsIdentifier::new);
        MAPPINGS.put("Literal", JsLiteral::new);
        MAPPINGS.put("ExpressionStatement", JsExpressionStatement::new);
        MAPPINGS.put("CallExpression", JsCallExpression::new);
        MAPPINGS.put("MemberExpression", JsMemberExpression::new);
        MAPPINGS.put("IfStatement", JsIfStatement::new);
    }

    public static AJackdawWeaverJoinPoint create(JsonObject node) {
        String type = node.get("type").getAsString();

        Function<JsonObject, AJackdawWeaverJoinPoint> mapper = MAPPINGS.get(type);
        if (mapper == null) {
            SpecsLogs.debug(() -> "Creating generic join point for node of type '" + type + "'");
            return new JsGeneric(node);
            // throw new NotImplementedException("Join point mappings not implemented for type '" + type + "'");
        }

        return mapper.apply(node);
    }

}
