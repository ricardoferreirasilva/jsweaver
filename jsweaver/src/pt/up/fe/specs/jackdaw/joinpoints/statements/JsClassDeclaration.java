package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AClassDeclaration;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;

public class JsClassDeclaration extends AClassDeclaration {

    private final JsonObject node;

    public JsClassDeclaration(JsonObject node) {
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    @Override
    public AJoinPoint getIdImpl() {
        if (node.has("id")) {
            return JoinpointCreator.create(node.get("id").getAsJsonObject());
        } else
            return null;
    }

    @Override
    public AJoinPoint getSuperclassImpl() {
        if (node.has("superClass")) {
            return JoinpointCreator.create(node.get("superClass").getAsJsonObject());
        } else
            return null;
    }

}
