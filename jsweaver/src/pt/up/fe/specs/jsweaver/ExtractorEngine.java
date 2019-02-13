package pt.up.fe.specs.jsweaver;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jsweaver.abstracts.joinpoints.ADeclaration;

// Class that hosts several functions to extract AST elements from JSON.
public class ExtractorEngine {

    // Extract VariableDeclarators from a list of statements.
    public static List<? extends ADeclaration> getAllDeclarations(JsonArray statements) {
        System.out.println(statements);
        List<ADeclaration> list = new ArrayList<ADeclaration>();
        for (JsonElement statementElement : statements) {
            JsonObject statement = statementElement.getAsJsonObject();
            String type = statement.get("type").getAsString();
            if (type.equals("VariableDeclaration")) {
                JsonArray declarations = statement.get("declarations").getAsJsonArray();
                for (JsonElement declaration : declarations) {
                    JsonObject declarationObject = declaration.getAsJsonObject();
                    ADeclaration declarationJoinPoint = (ADeclaration) JsJoinpoints.create(declarationObject);
                    list.add(declarationJoinPoint);
                }
            }
        }
        return list;
    }
}
