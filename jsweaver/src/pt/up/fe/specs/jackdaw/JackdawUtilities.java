package pt.up.fe.specs.jackdaw;

import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JackdawUtilities {
	public static void reformParents(JsonObject node) {
		ParentMapper.parentMap = new HashMap();
		formParents(node);
	}

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

	public static boolean nodeIsInsertable(JsonObject node) {

		if (node.has("type")) {
			String type = node.get("type").getAsString();
			if (type.equals("Program") || type.equals("BlockStatement")) {
				return true;
			} else
				return false;
		} else {
			return false;
		}
	}

}
