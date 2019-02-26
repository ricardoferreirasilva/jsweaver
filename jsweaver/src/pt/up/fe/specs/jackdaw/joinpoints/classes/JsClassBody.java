package pt.up.fe.specs.jackdaw.joinpoints.classes;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AClassBody;

public class JsClassBody extends AClassBody {

    private final JsonObject node;

    public JsClassBody(JsonObject node) {
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }
}
