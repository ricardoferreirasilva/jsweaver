package pt.up.fe.specs.jackdaw.joinpoints.statements;

import java.util.Collections;
import java.util.List;

import org.lara.interpreter.weaver.interf.SelectOp;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AScope;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AStatement;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ATryStatement;
import pt.up.fe.specs.util.SpecsCheck;

public class JsTryStatement extends ATryStatement {

	private final JsonObject node;
	public JsTryStatement(JsonObject node) {
		this.node = node;
	}

	@Override
	public JsonObject getNode() {
		return this.node;
	}
	@Override
	    public List<? extends AScope> selectBlock() {
	        List<AStatement> block = JoinpointCreator.createFromField(node, "block", AStatement.class);
	        if (block.isEmpty()) {
	            return Collections.emptyList();
	        }

	        SpecsCheck.checkArgument(block.size() == 1, () -> "Expected field to have only one child");

	        return block.get(0).select(AScope.class, SelectOp.CHILDREN);
	    }
}
