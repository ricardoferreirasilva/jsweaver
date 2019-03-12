package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AWhileStatement;
import pt.up.fe.specs.jackdaw.enums.LoopKind;

public class JsWhileStatement extends AWhileStatement {
	private final JsonObject node;

	public JsWhileStatement(JsonObject node) {
		super(new JsLoop(node));
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

	@Override
	public LoopKind getKindImpl() {
		return LoopKind.WHILE;
	}

}
