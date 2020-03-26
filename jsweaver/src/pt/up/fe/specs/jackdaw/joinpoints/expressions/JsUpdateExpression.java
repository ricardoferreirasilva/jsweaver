package pt.up.fe.specs.jackdaw.joinpoints.expressions;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AUpdateExpression;

public class JsUpdateExpression extends AUpdateExpression {
    private final JsonObject node;

    public JsUpdateExpression(JsonObject node) {
        super(new JsExpression(node));
        this.node = node;
    }

    @Override
    public AJoinPoint getArgumentImpl() {
        return JoinpointCreator.create(this.node.get("argument").getAsJsonObject());
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    @Override
    public String getOperatorImpl() {
        return this.node.get("operator").getAsString();
    }

    @Override
    public Boolean getPrefixImpl() {
        return this.node.get("prefix").getAsBoolean();
    }

}
