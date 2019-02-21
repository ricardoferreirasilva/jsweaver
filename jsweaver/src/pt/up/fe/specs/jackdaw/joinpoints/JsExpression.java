package pt.up.fe.specs.jackdaw.joinpoints;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.AJackdawWeaverJoinPoint;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ACallExpression;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AExpression;

public class JsExpression extends AExpression {

    private final JsonObject node;
    private static final Set<String> EXPRESSION_TYPES;
    static {
        EXPRESSION_TYPES = new HashSet<>(Arrays.asList("ThisExpression", "Identifier", "Literal", "ArrayExpression",
                "ObjectExpression", "FunctionExpression", "ArrowFunctionExpression", "ClassExpression",
                "TaggedTemplateExpression", "MemberExpression", "Super", "MetaProperty", "NewExpression",
                "CallExpression", "UpdateExpression", "AwaitExpression",
                "UnaryExpression", "BinaryExpression", "LogicalExpression", "ConditionalExpression", "YieldExpression",
                "AssignmentExpression", "SequenceExpression"));
    }

    public JsExpression(JsonObject node) {
        this.node = node;
    }

    public static boolean isExpression(String type) {
        return EXPRESSION_TYPES.contains(type);
    }

    @Override
    public List<? extends ACallExpression> selectCallExpression() {
        return getExpression(ACallExpression.class);
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    private <T extends AExpression> List<T> getExpression(Class<T> expressionClass) {
        AJackdawWeaverJoinPoint stmt = JoinpointCreator.create(node);
        return expressionClass.isInstance(stmt) ? Arrays.asList(expressionClass.cast(stmt))
                : Collections.emptyList();
    }
}
