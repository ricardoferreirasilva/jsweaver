package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ASwitchCase;

public class JsSwitchCase extends ASwitchCase {
	private final JsonObject node;
    public JsSwitchCase(JsonObject node) {
        this.node = node;
    }
	@Override
	public AJoinPoint getTestImpl() {
		if(this.node.has("test") && this.node.get("test").isJsonObject()) return JoinpointCreator.create(this.node.get("test").getAsJsonObject());
		else return null;
	}

	@Override
	public JsonObject getNode() {
		return this.node;
	}

}
