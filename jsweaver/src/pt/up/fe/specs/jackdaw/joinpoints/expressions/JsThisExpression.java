package pt.up.fe.specs.jackdaw.joinpoints.expressions;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AThisExpression;

public class JsThisExpression extends AThisExpression {

    private final JsonObject node;

    public JsThisExpression(JsonObject node) {
        super(new JsExpression(node));
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

}
