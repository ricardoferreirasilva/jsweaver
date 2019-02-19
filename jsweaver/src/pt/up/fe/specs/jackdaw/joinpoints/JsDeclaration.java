package pt.up.fe.specs.jackdaw.joinpoints;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ADeclaration;

public class JsDeclaration extends ADeclaration {
    private final JsonObject declarationJSON;

    public JsDeclaration(JsonObject declarationJSON) {
        this.declarationJSON = declarationJSON;
    }

    @Override
    public JsonObject getNode() {
        return this.declarationJSON;
    }

    @Override
    public String getKindImpl() {
        String kind = this.declarationJSON.get("kind").getAsString();
        return kind;
    }

}
