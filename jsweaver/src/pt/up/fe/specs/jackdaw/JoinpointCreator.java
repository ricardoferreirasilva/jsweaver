package pt.up.fe.specs.jackdaw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.AJackdawWeaverJoinPoint;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jackdaw.joinpoints.*;
import pt.up.fe.specs.jackdaw.joinpoints.classes.*;
import pt.up.fe.specs.jackdaw.joinpoints.expressions.*;
import pt.up.fe.specs.jackdaw.joinpoints.statements.*;
import pt.up.fe.specs.util.SpecsLogs;

public class JoinpointCreator {

    private static final Map<String, Function<JsonObject, AJackdawWeaverJoinPoint>> MAPPINGS;
    static {
        MAPPINGS = new HashMap<>();
        MAPPINGS.put("Project", JsProject::new);
        MAPPINGS.put("Program", JsFile::new);
        MAPPINGS.put("VariableDeclaration", JsDeclaration::new);
        MAPPINGS.put("FunctionDeclaration", JsFunctionDeclaration::new);
        MAPPINGS.put("FunctionExpression", JsFunctionExpression::new);
        MAPPINGS.put("ClassDeclaration", JsClassDeclaration::new);
        MAPPINGS.put("VariableDeclarator", JsDeclarator::new);
        MAPPINGS.put("MethodDefinition", JsMethodDefinition::new);
        MAPPINGS.put("Identifier", JsIdentifier::new);
        MAPPINGS.put("Literal", JsLiteral::new);
        MAPPINGS.put("ExpressionStatement", JsExpressionStatement::new);
        MAPPINGS.put("WhileStatement", JsWhileStatement::new);
        MAPPINGS.put("SwitchStatement", JsSwitchStatement::new);
        MAPPINGS.put("SwitchCase", JsSwitchCase::new);
        MAPPINGS.put("ForStatement", JsForStatement::new);
        MAPPINGS.put("BlockStatement", JsBlockStatement::new);
        MAPPINGS.put("ClassBody", JsClassBody::new);
        MAPPINGS.put("CallExpression", JsCallExpression::new);
        MAPPINGS.put("BinaryExpression", JsBinaryExpression::new);
        MAPPINGS.put("AssignmentExpression", JsAssignmentExpression::new);
        MAPPINGS.put("UpdateExpression", JsUpdateExpression::new);
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

    public static <T extends AJoinPoint> List<T> createFromField(JsonObject node, String fieldName,
            Class<T> targetClass) {

        return JackdawQueryEngine.queryNodeGeneric(node, fieldName, targetClass, false);
    }

}
