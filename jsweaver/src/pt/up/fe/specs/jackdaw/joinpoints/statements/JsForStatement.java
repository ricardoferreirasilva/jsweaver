package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AForStatement;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jackdaw.enums.LoopKind;

public class JsForStatement extends AForStatement {
	private final JsonObject node;

	public JsForStatement(JsonObject node) {
		super(new JsLoop(node));
		this.node = node;
	}

	@Override
	public AJoinPoint getInitImpl() {
		if (this.node.has("init"))
			return JoinpointCreator.create(this.node.get("init").getAsJsonObject());
		else
			return null;
	}

	@Override
	public AJoinPoint getTestImpl() {
		if (this.node.has("test"))
			return JoinpointCreator.create(this.node.get("test").getAsJsonObject());
		else
			return null;
	}

	@Override
	public AJoinPoint getUpdateImpl() {
		if (this.node.has("update"))
			return JoinpointCreator.create(this.node.get("update").getAsJsonObject());
		else
			return null;
	}

	@Override
	public JsonObject getNode() {
		return this.node;
	}

	@Override
	public LoopKind getKindImpl() {
		return LoopKind.FOR;
	}

}
