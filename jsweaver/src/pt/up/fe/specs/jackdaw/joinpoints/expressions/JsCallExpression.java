package pt.up.fe.specs.jackdaw.joinpoints.expressions;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ACallExpression;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;

public class JsCallExpression extends ACallExpression {
    private final JsonObject node;

    public JsCallExpression(JsonObject node) {
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    @Override
    public AJoinPoint getCalleeImpl() {
        return JoinpointCreator.create(this.node.get("callee").getAsJsonObject());
    }

    @Override
    public AJoinPoint[] getArgumentsArrayImpl() {
        List<AJoinPoint> arguments = new ArrayList<AJoinPoint>();
        JsonArray argumentElements = this.node.get("arguments").getAsJsonArray();
        for (JsonElement argument : argumentElements) {
            // SpecsLogs.test("" + argument.getAsJsonObject());
            arguments.add(JoinpointCreator.create(argument.getAsJsonObject()));
        }
        AJoinPoint[] joinpointArguments = arguments.toArray(new AJoinPoint[arguments.size()]);
        return (joinpointArguments);
    }
    @Override
    public String getNameImpl() {
    	JsonObject callee = this.node.get("callee").getAsJsonObject();
    	return getNameFromCallNode(callee);
    }
    private String getNameFromCallNode(JsonObject node) {
    	switch (node.get("type").getAsString()) {
		case "Identifier":
			return node.get("name").getAsString();
		case "MemberExpression":
			return (getNameFromCallNode(node.get("object").getAsJsonObject())+"."+getNameFromCallNode(node.get("property").getAsJsonObject()));
		default:
			return node.get("type").getAsString();
		}
    }

}
