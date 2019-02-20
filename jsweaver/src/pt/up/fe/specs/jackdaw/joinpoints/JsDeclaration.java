package pt.up.fe.specs.jackdaw.joinpoints;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JackdawQueryEngine;
import pt.up.fe.specs.jackdaw.JsJoinpoints;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ADeclaration;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ADeclarator;

public class JsDeclaration extends ADeclaration {
    private final JsonObject node;

    public JsDeclaration(JsonObject node) {
        super(new JsStatement(node));
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

    @Override
    public List<? extends ADeclarator> selectDeclarator() {
        List<ADeclarator> results = new ArrayList<ADeclarator>();
        JsonArray declarators = JackdawQueryEngine.queryNode(node, "VariableDeclarator", true);
        for (JsonElement declarator : declarators) {
            ADeclarator declaratorJoinpoint = (ADeclarator) JsJoinpoints.create(declarator.getAsJsonObject());
            results.add(declaratorJoinpoint);
        }
        return results;
    }

}
