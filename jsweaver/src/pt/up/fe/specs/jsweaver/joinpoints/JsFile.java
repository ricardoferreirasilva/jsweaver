package pt.up.fe.specs.jsweaver.joinpoints;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jsweaver.JackdawQueryEngine;
import pt.up.fe.specs.jsweaver.JsJoinpoints;
import pt.up.fe.specs.jsweaver.abstracts.joinpoints.ADeclaration;
import pt.up.fe.specs.jsweaver.abstracts.joinpoints.AFile;

public class JsFile extends AFile {

    private final JsonObject fileJSON;

    public JsFile(JsonObject file) {
        this.fileJSON = file;
    }

    @Override
    public JsonObject getNode() {
        return this.fileJSON;
    }

    @Override
    public String getPathImpl() {
        String path = fileJSON.get("path").getAsString();
        return path;
    }

    @Override
    public List<? extends ADeclaration> selectDeclaration() {
        JsonArray statements = fileJSON.get("body").getAsJsonArray();

        List<ADeclaration> results = new ArrayList<ADeclaration>();
        JsonArray declarators = JackdawQueryEngine.queryNode(fileJSON, "VariableDeclarator", true);
        for (JsonElement declarator : declarators) {
            ADeclaration declarationJoinPoint = (ADeclaration) JsJoinpoints.create(declarator.getAsJsonObject());
            results.add(declarationJoinPoint);
        }
        return results;
    }

}
