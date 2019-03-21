package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ABreakStatement;

public class JsBreakStatement extends ABreakStatement {

	private final JsonObject node;

	public JsBreakStatement(JsonObject node) {
		this.node = node;
	}

	@Override
	public JsonObject getNode() {
		return this.node;
	}

}
