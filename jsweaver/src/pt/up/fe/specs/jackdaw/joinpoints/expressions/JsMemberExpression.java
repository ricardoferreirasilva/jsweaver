package pt.up.fe.specs.jackdaw.joinpoints.expressions;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AMemberExpression;

public class JsMemberExpression extends AMemberExpression {

    private final JsonObject node;

    public JsMemberExpression(JsonObject node) {
        super(new JsExpression(node));
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    @Override
    public Boolean getComputedImpl() {
        return this.node.get("computed").getAsBoolean();
    }

    @Override
    public AJoinPoint getObjectImpl() {
        return JoinpointCreator.create(this.node.get("object").getAsJsonObject());
    }

    @Override
    public AJoinPoint getPropertyImpl() {
        return JoinpointCreator.create(this.node.get("property").getAsJsonObject());
    }

}
