package pt.up.fe.specs.jsweaver.joinpoints;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jsweaver.abstracts.joinpoints.ADeclaration;

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
    public String getIdImpl() {
        JsonObject id = this.declarationJSON.get("id").getAsJsonObject();
        String id_name = id.get("name").getAsString();
        return id_name;
    }

}
