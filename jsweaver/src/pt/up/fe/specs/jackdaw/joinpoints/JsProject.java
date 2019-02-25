package pt.up.fe.specs.jackdaw.joinpoints;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AProject;

public class JsProject extends AProject {

    private final JsonObject project;

    public JsProject(JsonObject project) {
        this.project = project;
    }

    @Override
    public JsonObject getNode() {
        return this.project;
    }

}
