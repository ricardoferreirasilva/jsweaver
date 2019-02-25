package pt.up.fe.specs.jackdaw.joinpoints.statements;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JackdawQueryEngine;
import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AIfStatement;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AStatement;
import pt.up.fe.specs.jackdaw.joinpoints.JsStatement;

public class JsIfStatement extends AIfStatement {

    private final JsonObject node;

    public JsIfStatement(JsonObject node) {
        super(new JsStatement(node));
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    @Override
    public AJoinPoint getTestImpl() {
        return JoinpointCreator.create(this.node.get("test").getAsJsonObject());
    }

    @Override
    public List<? extends AStatement> selectStatement() {
        List<AStatement> results = new ArrayList<AStatement>();
        JsonArray statements = JackdawQueryEngine.queryNode(node, type -> JsStatement.isStatement(type), true);
        for (JsonElement statement : statements) {
            AStatement declarationJoinPoint = (AStatement) JoinpointCreator.create(statement.getAsJsonObject());
            results.add(declarationJoinPoint);
        }
        return results;
    }
}
