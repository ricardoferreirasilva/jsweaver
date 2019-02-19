package pt.up.fe.specs.jackdaw;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.AJackdawWeaverJoinPoint;
import pt.up.fe.specs.jackdaw.joinpoints.JsDeclaration;
import pt.up.fe.specs.jackdaw.joinpoints.JsFile;
import pt.up.fe.specs.jackdaw.joinpoints.JsGeneric;
import pt.up.fe.specs.jackdaw.joinpoints.JsProject;
import pt.up.fe.specs.util.SpecsLogs;

public class JsJoinpoints {

    private static final Map<String, Function<JsonObject, AJackdawWeaverJoinPoint>> MAPPINGS;
    static {
        MAPPINGS = new HashMap<>();
        MAPPINGS.put("Project", JsProject::new);
        MAPPINGS.put("Program", JsFile::new);
        MAPPINGS.put("VariableDeclarator", JsDeclaration::new);
    }

    public static AJackdawWeaverJoinPoint create(JsonObject node) {
        String type = node.get("type").getAsString();

        Function<JsonObject, AJackdawWeaverJoinPoint> mapper = MAPPINGS.get(type);
        if (mapper == null) {
            SpecsLogs.debug(() -> "Creating generic join point for node of type '" + type + "'");
            return new JsGeneric(node);
            // throw new NotImplementedException("Join point mappings not implemented for type '" + type + "'");
        }

        return mapper.apply(node);
    }

}
