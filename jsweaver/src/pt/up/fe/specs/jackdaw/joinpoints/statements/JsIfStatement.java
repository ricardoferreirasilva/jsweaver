package pt.up.fe.specs.jackdaw.joinpoints.statements;

import java.util.Collections;
import java.util.List;

import org.lara.interpreter.weaver.interf.SelectOp;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AIfStatement;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AScope;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AStatement;
import pt.up.fe.specs.jackdaw.joinpoints.JsStatement;
import pt.up.fe.specs.util.SpecsCheck;

public class JsIfStatement extends AIfStatement {

    private final JsonObject node;

    public JsIfStatement(JsonObject node) {
        super(new JsStatement(node));
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    @Override
    public AJoinPoint getTestImpl() {
        return JoinpointCreator.create(this.node.get("test").getAsJsonObject());
    }

    @Override
    public List<? extends AScope> selectThen() {
        List<AStatement> consequent = JoinpointCreator.createFromField(node, "consequent", AStatement.class);
        if (consequent.isEmpty()) {
            return Collections.emptyList();
        }

        SpecsCheck.checkArgument(consequent.size() == 1, () -> "Expected field to have only one child");

        return consequent.get(0).select(AScope.class, SelectOp.CHILDREN);
    }

    @Override
    public List<? extends AScope> selectElse() {
        List<AStatement> consequent = JoinpointCreator.createFromField(node, "alternate", AStatement.class);
        if (consequent.isEmpty()) {
            return Collections.emptyList();
        }

        SpecsCheck.checkArgument(consequent.size() == 1, () -> "Expected field to have only one child");

        return consequent.get(0).select(AScope.class, SelectOp.CHILDREN);
    }
}
