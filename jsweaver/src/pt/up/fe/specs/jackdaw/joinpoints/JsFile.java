package pt.up.fe.specs.jackdaw.joinpoints;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JackdawQueryEngine;
import pt.up.fe.specs.jackdaw.JsJoinpoints;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ADeclaration;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AFile;

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
        List<ADeclaration> results = new ArrayList<ADeclaration>();
        JsonArray declarators = JackdawQueryEngine.queryNode(fileJSON, "VariableDeclaration", true);
        for (JsonElement declarator : declarators) {
            ADeclaration declarationJoinPoint = (ADeclaration) JsJoinpoints.create(declarator.getAsJsonObject());
            results.add(declarationJoinPoint);
        }
        return results;
    }

}
