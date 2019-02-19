package pt.up.fe.specs.jackdaw.joinpoints;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.AJackdawWeaverJoinPoint;

public class JsGeneric extends AJackdawWeaverJoinPoint {

    private final JsonObject node;

    public JsGeneric(JsonObject node) {
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return node;
    }

}
