package pt.up.fe.specs.jackdaw;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;

public class ParentMapper {

    private static Map<JsonObject, JsonObject> PARENT_MAP = new HashMap<>();
    private static boolean IS_DIRTY = true;
    private static int SET_DIRTY_COUNT = 0;
    private static int GET_PARENT_COUNT = 0;
    private static int RECONSTRUCTION_COUNT = 0;

    public static void clear() {
        PARENT_MAP = new HashMap<>();
    }

    public static void putPair(JsonObject child, JsonObject parent) {
        PARENT_MAP.put(child, parent);
    }

    public static void setDirty() {
        IS_DIRTY = true;
        SET_DIRTY_COUNT++;
    }

    public static int getParentCount() {
        return GET_PARENT_COUNT;
    }

    public static int getReconstructionCount() {
        return RECONSTRUCTION_COUNT;
    }

    public static int getSetDirtyCount() {
        return SET_DIRTY_COUNT;
    }

    public static JsonObject getParent(JsonObject child) {
        GET_PARENT_COUNT++;
        if (IS_DIRTY) {
            ParentMapper.clear();
            JackdawUtilities.formParents(JackdawWeaver.getJackdawWeaver().getProject());
            IS_DIRTY = false;
        }
        JsonObject node = PARENT_MAP.get(child);
        if (node != null)
            return node;
        else {
            throw new RuntimeException("Parent node is null.");
        }
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

    public static JsonObject getFile(JsonObject node) {
        Boolean foundRoot = false;

        // Node is already the root.
        if (node.has("type") && node.get("type").getAsString().equals("Program")) {
            foundRoot = true;
            return node;
        }
        while (!foundRoot) {
            JsonObject parent = getParent(node);
            if (parent.has("type") && parent.get("type").getAsString().equals("Program")) {
                foundRoot = true;
                return parent;
            } else {
                node = parent;
            }

        }
        return null;
    }
    // public static void printMap() {
    // for (JsonObject key : PARENT_MAP.keySet()) {
    // // System.out.println(key);
    //
    // }
    //
    // }
}
