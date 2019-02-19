package pt.up.fe.specs.jackdaw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ADeclaration;

// Class that hosts several functions to extract AST elements from JSON.
public class JackdawQueryEngine {

    // Extract VariableDeclarators from a list of statements.
    public static List<? extends ADeclaration> getAllDeclarations(JsonArray statements) {
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

    public static void jsonIterate(JsonObject jsonObj) {
        for (Entry<String, JsonElement> key : jsonObj.entrySet()) {
            String keyName = key.getKey();
            JsonElement keyValue = key.getValue();
            System.out.println("key: " + keyName + " value: " + keyValue);
        }

    }

    // Search for an object by its type in level 1 deepness.
    public static JsonArray queryNode(JsonObject node, String type, Boolean indirectDescendents) {
        JsonArray foundElements = new JsonArray();
        String startingType = node.get("type").getAsString();

        for (Entry<String, JsonElement> key : node.entrySet()) {
            String keyName = key.getKey();
            JsonElement keyValue = key.getValue();
            // System.out.println("key: " + keyName + " value: " + keyValue);

            if (keyValue.isJsonObject()) {
                if (keyValue.getAsJsonObject().get("type").getAsString().equals(type)) {
                    foundElements.add(keyValue);
                } else {
                    if (indirectDescendents) {
                        foundElements.addAll(queryNode(keyValue.getAsJsonObject(), type, false));
                    }
                }

            } else if (keyValue.isJsonArray()) {
                JsonArray elements = keyValue.getAsJsonArray();
                for (JsonElement singleElement : elements) {
                    if (singleElement.isJsonObject()) {
                        if (singleElement.getAsJsonObject().get("type").getAsString().equals(type)) {
                            foundElements.add(singleElement);
                        } else {
                            if (indirectDescendents) {
                                foundElements.addAll(queryNode(singleElement.getAsJsonObject(), type, false));
                            }
                        }
                    }

                }
            }
        }
        return foundElements;
    }

    // Checks if a node is a direct child of a parent node.
    public static Boolean isChild(JsonObject parent, JsonObject child) {
        for (Entry<String, JsonElement> key : parent.entrySet()) {
            String keyName = key.getKey();
            JsonElement keyValue = key.getValue();
            if (keyValue.isJsonObject()) {
                if (keyValue.getAsJsonObject().equals(child)) {
                    return true;
                }

            } else if (keyValue.isJsonArray()) {
                JsonArray elements = keyValue.getAsJsonArray();
                for (JsonElement singleElement : elements) {
                    if (singleElement.getAsJsonObject().equals(child)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
