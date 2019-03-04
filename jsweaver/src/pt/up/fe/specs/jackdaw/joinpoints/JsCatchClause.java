package pt.up.fe.specs.jackdaw.joinpoints;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ACatchClause;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;

public class JsCatchClause extends ACatchClause {

	private final JsonObject node;
	public JsCatchClause(JsonObject node) {
		this.node = node;
	}

	@Override
	public AJoinPoint getParamImpl() {
		return JoinpointCreator.create(this.node.get("param").getAsJsonObject());
	}

	@Override
	public JsonObject getNode() {
		return this.node;
	}

}
