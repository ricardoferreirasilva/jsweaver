package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ADeclaration;

public class JsDeclaration extends ADeclaration {
    private final JsonObject node;

    public JsDeclaration(JsonObject node) {
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    @Override
    public String getKindImpl() {
        String kind = this.node.get("kind").getAsString();
        return kind;
    }

}
