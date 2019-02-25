package pt.up.fe.specs.jackdaw.joinpoints.statements;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AFunctionDeclaration;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;

public class JsFunctionDeclaration extends AFunctionDeclaration {

    private final JsonObject node;

    public JsFunctionDeclaration(JsonObject node) {
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return node;
    }

    @Override
    public AJoinPoint getIdImpl() {
        return JoinpointCreator.create(this.node.getAsJsonObject("id").getAsJsonObject());
    }

    @Override
    public AJoinPoint[] getParamsArrayImpl() {
        List<AJoinPoint> arguments = new ArrayList<AJoinPoint>();
        JsonArray argumentElements = this.node.get("params").getAsJsonArray();
        for (JsonElement argument : argumentElements) {
            // SpecsLogs.test("" + argument.getAsJsonObject());
            arguments.add(JoinpointCreator.create(argument.getAsJsonObject()));
        }
        AJoinPoint[] joinpointArguments = arguments.toArray(new AJoinPoint[arguments.size()]);
        return (joinpointArguments);
    }

    @Override
    public Boolean getAsyncImpl() {
        return this.node.get("async").getAsBoolean();
    }

    @Override
    public Boolean getGeneratorImpl() {
        return this.node.get("generator").getAsBoolean();
    }

    @Override
    public Boolean getExpressionImpl() {
        return false;
    }

}
