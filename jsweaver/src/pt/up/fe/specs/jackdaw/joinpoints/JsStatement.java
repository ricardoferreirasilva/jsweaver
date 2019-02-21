package pt.up.fe.specs.jackdaw.joinpoints;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.AJackdawWeaverJoinPoint;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ADeclaration;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AExpressionStatement;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AStatement;

public class JsStatement extends AStatement {

    private static final Set<String> STATEMENT_TYPES;
    static {
        STATEMENT_TYPES = new HashSet<>(Arrays.asList("BlockStatement", "BreakStatement", "ContinueStatement",
                "DebuggerStatement", "DoWhileStatement", "EmptyStatement", "ExpressionStatement", "ForStatement",
                "ForInStatement", "ForOfStatement", "FunctionDeclaration", "IfStatement", "LabeledStatement",
                "ReturnStatement", "SwitchStatement", "ThrowStatement", "TryStatement", "VariableDeclaration",
                "WhileStatement", "WithStatement"));
    }

    private final JsonObject node;

    public JsStatement(JsonObject node) {
        this.node = node;
    }

    public static boolean isStatement(String type) {
        return STATEMENT_TYPES.contains(type);
    }

    @Override
    public JsonObject getNode() {
        return node;
    }

    @Override
    public List<? extends AExpressionStatement> selectExpressionStatement() {
        return getStatement(AExpressionStatement.class);
    }

    @Override
    public List<? extends ADeclaration> selectDeclaration() {
        return getStatement(ADeclaration.class);
    }

    private <T extends AStatement> List<T> getStatement(Class<T> stmtClass) {
        AJackdawWeaverJoinPoint stmt = JoinpointCreator.create(node);
        return stmtClass.isInstance(stmt) ? Arrays.asList(stmtClass.cast(stmt))
                : Collections.emptyList();
    }

}
