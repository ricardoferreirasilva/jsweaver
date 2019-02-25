package pt.up.fe.specs.jackdaw.joinpoints.statements;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ABlockStatement;
import pt.up.fe.specs.jackdaw.joinpoints.JsStatement;

public class JsBlockStatement extends ABlockStatement {

    private final JsonObject node;

    public JsBlockStatement(JsonObject node) {
        super(new JsStatement(node));
        this.node = node;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    // @Override
    // public List<? extends AStatement> selectStatement() {
    // List<AStatement> results = new ArrayList<AStatement>();
    // JsonArray statements = JackdawQueryEngine.queryNode(node, type -> JsStatement.isStatement(type), true);
    // for (JsonElement statement : statements) {
    // AStatement declarationJoinPoint = (AStatement) JoinpointCreator.create(statement.getAsJsonObject());
    // results.add(declarationJoinPoint);
    // }
    // return results;
    // }

    // @Override
    // public List<? extends AScope> selectScope() {
    // return Arrays.asList(new JsScope(node));
    // }
}
