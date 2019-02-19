package pt.up.fe.specs.jsweaver;

import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JackdawUtilities {

    public static void formParents(JsonObject node) {
        for (Entry<String, JsonElement> key : node.entrySet()) {
            String keyName = key.getKey();
            JsonElement keyValue = key.getValue();
            if (keyValue.isJsonObject()) {
                JsonObject keyObject = keyValue.getAsJsonObject();
                ParentMapper.putPair(keyObject, node);
                formParents(keyObject);

            } else if (keyValue.isJsonArray()) {
                JsonArray elements = keyValue.getAsJsonArray();
                for (JsonElement singleElement : elements) {
                    if (singleElement.isJsonObject()) {
                        JsonObject keyObject = singleElement.getAsJsonObject();
                        ParentMapper.putPair(keyObject, node);
                        formParents(singleElement.getAsJsonObject());
                    }
                }
            }
        }
    }
}
