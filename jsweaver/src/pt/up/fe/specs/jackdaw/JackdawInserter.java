package pt.up.fe.specs.jackdaw;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JackdawInserter {

    public static void insertStatements(JsonObject node, JsonArray newElements, String position) {
        // First find insertable zone
        Boolean zoneFound = false;
        if (JackdawUtilities.nodeIsInsertable(node)) {
            zoneFound = true;
            insertIntoBody(node, newElements, position);
        } else {
            while (!zoneFound) {
                JsonObject anchorNode = node;
                node = ParentMapper.getParent(node);
                if (JackdawUtilities.nodeIsInsertable(node)) {
                    zoneFound = true;
                    insertIntoBody(node, anchorNode, newElements, position);
                    break;
                }
            }
        }
    }

    public static void insertJoinPoint(JsonObject node, JsonObject newNode, String position) {
        // First find insertable zone
        Boolean zoneFound = false;
        if (JackdawUtilities.nodeIsInsertable(node)) {
            zoneFound = true;
            insertIntoBody(node, newNode, position);
        } else {
            while (!zoneFound) {
                JsonObject anchorNode = node;
                node = ParentMapper.getParent(node);
                if (JackdawUtilities.nodeIsInsertable(node)) {
                    zoneFound = true;
                    insertIntoBody(node, anchorNode, newNode, position);
                    break;
                }
            }
        }
    }

    // Insert into a list of elements into a body of statements with no anchor.
    private static void insertIntoBody(JsonObject insertNode, JsonArray elems, String position) {
        JsonArray elements = insertNode.get("body").getAsJsonArray();
        JsonArray newElements = new JsonArray();
        if (!position.equals("replace")) {
            if (position.equals("before")) {
                newElements.addAll(elems);
            }
            for (JsonElement elem : elements) {
                JsonObject currentNode = elem.getAsJsonObject();
                newElements.add(currentNode);

            }
            if (position.equals("after")) {
                newElements.addAll(elems);
            }
        } else {
            newElements.addAll(elems);
        }
        insertNode.add("body", newElements);
    }

    // Insert into a body of statements with no anchor.
    private static void insertIntoBody(JsonObject insertNode, JsonObject newNode, String position) {
        JsonArray elements = insertNode.get("body").getAsJsonArray();
        JsonArray newElements = new JsonArray();
        if (!position.equals("replace")) {
            if (position.equals("before")) {
                newElements.add(newNode);
            }
            for (JsonElement elem : elements) {
                JsonObject currentNode = elem.getAsJsonObject();
                newElements.add(currentNode);

            }
            if (position.equals("after")) {
                newElements.add(newNode);
            }
        } else {
            newElements.add(newNode);
        }
        insertNode.add("body", newElements);
    }

    // Insert a list of statements into a body of statements with an anchor
    private static void insertIntoBody(JsonObject insertNode, JsonObject anchorNode, JsonArray elems, String position) {
        JsonArray elements = insertNode.get("body").getAsJsonArray();
        JsonArray newElements = new JsonArray();
        for (JsonElement elem : elements) {
            JsonObject currentNode = elem.getAsJsonObject();
            if (currentNode.equals(anchorNode)) {
                if (position.equals("before")) {
                    newElements.addAll(elems);
                    newElements.add(anchorNode);
                } else if (position.equals("after")) {
                    newElements.add(anchorNode);
                    newElements.addAll(elems);
                } else if (position.equals("replace")) {
                    newElements.addAll(elems);
                }
            } else {
                newElements.add(elem);
            }
        }
        insertNode.add("body", newElements);

    }

    // Insert one node into a body of statements with an anchor
    private static void insertIntoBody(JsonObject insertNode, JsonObject anchorNode, JsonObject newNode,
            String position) {
        JsonArray elements = insertNode.get("body").getAsJsonArray();
        JsonArray newElements = new JsonArray();
        for (JsonElement elem : elements) {
            JsonObject currentNode = elem.getAsJsonObject();
            if (currentNode.equals(anchorNode)) {
                if (position.equals("before")) {
                    newElements.add(newNode);
                    newElements.add(anchorNode);
                } else if (position.equals("after")) {
                    newElements.add(anchorNode);
                    newElements.add(newNode);
                } else if (position.equals("replace")) {
                    newElements.add(newNode);
                }
            } else {
                newElements.add(elem);
            }
        }
        insertNode.add("body", newElements);

    }



}
