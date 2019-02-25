package pt.up.fe.specs.jackdaw.joinpoints;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.JsonObject;

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

}
