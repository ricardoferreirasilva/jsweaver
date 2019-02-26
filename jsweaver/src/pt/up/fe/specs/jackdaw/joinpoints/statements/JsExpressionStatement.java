package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AExpressionStatement;

public class JsExpressionStatement extends AExpressionStatement {

    private final JsonObject node;

    public JsExpressionStatement(JsonObject node) {

        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    @Override
    public String getDirectiveImpl() {
        if (this.node.has("directive")) {
            return this.node.get("directive").getAsString();
        } else {
            return "";
        }
    }
}
