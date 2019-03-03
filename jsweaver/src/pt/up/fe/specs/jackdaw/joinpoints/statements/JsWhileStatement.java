package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AWhileStatement;

public class JsWhileStatement extends AWhileStatement {
	private final JsonObject node;

    public JsWhileStatement(JsonObject node) {
        this.node = node;
    }
	@Override
	public AJoinPoint getTestImpl() {
		return JoinpointCreator.create(this.node.get("test").getAsJsonObject());
	}

	@Override
	public JsonObject getNode() {
		return this.node;
	}

}
