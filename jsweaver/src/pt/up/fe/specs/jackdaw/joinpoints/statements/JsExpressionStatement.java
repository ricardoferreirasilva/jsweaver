package pt.up.fe.specs.jackdaw.joinpoints.statements;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JackdawQueryEngine;
import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AExpression;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AExpressionStatement;
import pt.up.fe.specs.jackdaw.joinpoints.JsExpression;
import pt.up.fe.specs.jackdaw.joinpoints.JsStatement;

public class JsExpressionStatement extends AExpressionStatement {

    private final JsonObject node;

    public JsExpressionStatement(JsonObject node) {
        super(new JsStatement(node));

        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    @Override
    public String getDirectiveImpl() {
        if (this.node.has("directive")) {
            return this.node.get("directive").getAsString();
        } else {
            return "";
        }
    }

    @Override
    public List<? extends AExpression> selectExpression() {
        List<AExpression> results = new ArrayList<AExpression>();
        JsonArray statements = JackdawQueryEngine.queryNode(node, type -> JsExpression.isExpression(type), true);
        for (JsonElement statement : statements) {
            AExpression declarationJoinPoint = (AExpression) JoinpointCreator.create(statement.getAsJsonObject());
            results.add(declarationJoinPoint);
        }
        return results;
    }

}
