package pt.up.fe.specs.jackdaw.joinpoints;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AFile;

public class JsFile extends AFile {

    private final JsonObject node;

    public JsFile(JsonObject file) {
        this.node = file;
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    @Override
    public String getPathImpl() {
        String path = node.get("path").getAsString();
        return path;
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

    // public <T extends JoinPoint> List<? extends T> select(Class<T> jpClass) {
    // List<T> results = new ArrayList<T>();
    // JsonArray statements = JackdawQueryEngine.queryNode(node, type -> JsStatement.isStatement(type), true);
    // for (JsonElement statement : statements) {
    // T declarationJoinPoint = jpClass.cast(JoinpointCreator.create(statement.getAsJsonObject()));
    // results.add(declarationJoinPoint);
    // }
    // return results;
    //
    // }

}
