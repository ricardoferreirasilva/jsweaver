package pt.up.fe.specs.jackdaw.joinpoints;

import java.util.ArrayList;
import java.util.List;

import org.lara.interpreter.weaver.interf.JoinPoint;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JackdawQueryEngine;
import pt.up.fe.specs.jackdaw.JsJoinpoints;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AFile;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AStatement;

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

    @Override
    public List<? extends AStatement> selectStatement() {
        List<AStatement> results = new ArrayList<AStatement>();
        JsonArray statements = JackdawQueryEngine.queryNode(node, type -> JsStatement.isStatement(type), true);
        for (JsonElement statement : statements) {
            AStatement declarationJoinPoint = (AStatement) JsJoinpoints.create(statement.getAsJsonObject());
            results.add(declarationJoinPoint);
        }
        return results;
    }

    public <T extends JoinPoint> List<? extends T> select(Class<T> jpClass) {
        List<T> results = new ArrayList<T>();
        JsonArray statements = JackdawQueryEngine.queryNode(node, type -> JsStatement.isStatement(type), true);
        for (JsonElement statement : statements) {
            T declarationJoinPoint = jpClass.cast(JsJoinpoints.create(statement.getAsJsonObject()));
            results.add(declarationJoinPoint);
        }
        return results;

    }

}
