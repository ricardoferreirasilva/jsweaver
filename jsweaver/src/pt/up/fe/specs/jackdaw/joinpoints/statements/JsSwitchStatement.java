package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ASwitchStatement;

public class JsSwitchStatement extends ASwitchStatement {
	private final JsonObject node;

    public JsSwitchStatement(JsonObject node) {
        this.node = node;
    }
	@Override
	public AJoinPoint getDiscriminantImpl() {
		return JoinpointCreator.create(this.node.get("discriminant").getAsJsonObject());
	}

	@Override
	public JsonObject getNode() {
		return this.node;
	}

}
