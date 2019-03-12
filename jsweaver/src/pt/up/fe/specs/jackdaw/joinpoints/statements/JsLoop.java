package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ALoop;
import pt.up.fe.specs.jackdaw.enums.LoopKind;
import pt.up.fe.specs.util.exceptions.NotImplementedException;

public class JsLoop extends ALoop {

	private final JsonObject node;

	public JsLoop(JsonObject node) {
		this.node = node;
	}

	@Override
	public JsonObject getNode() {
		return node;
	}

	@Override
	public LoopKind getKindImpl() {
		throw new NotImplementedException(this);
	}

}
