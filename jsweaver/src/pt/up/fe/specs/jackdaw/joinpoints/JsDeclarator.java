package pt.up.fe.specs.jackdaw.joinpoints;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JsJoinpoints;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ADeclarator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;

public class JsDeclarator extends ADeclarator {
    private final JsonObject node;

    public JsDeclarator(JsonObject node) {
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    @Override
    public AJoinPoint getIdImpl() {
        return JsJoinpoints.create(node.get("id").getAsJsonObject());
    }

    @Override
    public AJoinPoint getInitImpl() {
        JsonObject initObject = this.node.get("init").getAsJsonObject();
        return JsJoinpoints.create(initObject);
    }

}
