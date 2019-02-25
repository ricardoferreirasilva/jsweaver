package pt.up.fe.specs.jackdaw.joinpoints;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AFile;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AProject;

public class JsProject extends AProject {

    private final JsonObject project;

    public JsProject(JsonObject project) {
        this.project = project;
    }

    @Override
    // Selects all added files of the project.
    public List<? extends AFile> selectFile() {
        List<AFile> list = new ArrayList<AFile>();
        JsonArray files = project.get("programs").getAsJsonArray();
        for (JsonElement file : files) {
            JsonObject fileJSON = file.getAsJsonObject();
            AFile fileJointPoint = (AFile) JoinpointCreator.create(fileJSON);
            list.add(fileJointPoint);
        }
        return list;
    }

    @Override
    public JsonObject getNode() {
        return this.project;
    }

}
