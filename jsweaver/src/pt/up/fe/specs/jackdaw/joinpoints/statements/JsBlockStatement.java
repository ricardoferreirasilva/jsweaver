package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ABlockStatement;
import pt.up.fe.specs.jackdaw.joinpoints.JsStatement;

public class JsBlockStatement extends ABlockStatement {

    private final JsonObject node;

    public JsBlockStatement(JsonObject node) {
        super(new JsStatement(node));
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

}
