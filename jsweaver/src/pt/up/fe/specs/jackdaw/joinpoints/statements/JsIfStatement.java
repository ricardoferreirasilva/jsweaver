package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AIfStatement;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
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

}
