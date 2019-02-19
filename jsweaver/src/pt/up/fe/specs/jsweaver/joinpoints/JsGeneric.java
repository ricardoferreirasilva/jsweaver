package pt.up.fe.specs.jsweaver.joinpoints;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jsweaver.abstracts.AJsWeaverJoinPoint;

public class JsGeneric extends AJsWeaverJoinPoint {

    private final JsonObject node;

    public JsGeneric(JsonObject node) {
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return node;
    }

}
