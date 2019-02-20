package pt.up.fe.specs.jackdaw.joinpoints;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ALiteral;

public class JsLiteral extends ALiteral {

    private final JsonObject node;

    public JsLiteral(JsonObject node) {
        this.node = node;
    }

    @Override
    public String getRawImpl() {
        return this.node.get("raw").getAsString();
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

}
