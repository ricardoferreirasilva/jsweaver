package pt.up.fe.specs.jsweaver;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;

public class ParentMapper {

    public static Map<JsonObject, JsonObject> parentMap = new HashMap();

    public static void putPair(JsonObject child, JsonObject parent) {
        parentMap.put(child, parent);
    }

    public static JsonObject getParent(JsonObject child) {
        return parentMap.get(child);
    }

    public static JsonObject getRoot(JsonObject node) {
        Boolean foundRoot = false;

        // Node is already the root.
        if (node.has("type") && node.get("type").getAsString().equals("Project")) {
            foundRoot = true;
            return node;
        }
        while (!foundRoot) {
            JsonObject parent = getParent(node);
            if (parent.has("type") && parent.get("type").getAsString().equals("Project")) {
                foundRoot = true;
                return parent;
            } else {
                node = parent;
            }

        }
        return null;
    }
}
