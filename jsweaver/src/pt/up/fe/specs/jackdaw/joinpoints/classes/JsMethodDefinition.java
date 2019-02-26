package pt.up.fe.specs.jackdaw.joinpoints.classes;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AMethodDefinition;

public class JsMethodDefinition extends AMethodDefinition {

    private final JsonObject node;

    public JsMethodDefinition(JsonObject node) {
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    @Override
    public AJoinPoint getKeyImpl() {
        if (this.node.has("key"))
            return JoinpointCreator.create(this.node.get("key").getAsJsonObject());
        else
            return null;
    }

    @Override
    public Boolean getComputedImpl() {
        return this.node.get("computed").getAsBoolean();
    }

    @Override
    public Boolean getStaticImpl() {
        return this.node.get("static").getAsBoolean();
    }

    @Override
    public String getKindImpl() {
        return this.node.get("kind").getAsString();
    }

}
