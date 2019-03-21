package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AContinueStatement;

public class JsContinueStatement extends AContinueStatement {

	private final JsonObject node;

	public JsContinueStatement(JsonObject node) {
		this.node = node;
	}

	@Override
	public JsonObject getNode() {
		return this.node;
	}
}
