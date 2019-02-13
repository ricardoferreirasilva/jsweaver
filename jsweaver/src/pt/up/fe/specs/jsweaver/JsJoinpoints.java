package pt.up.fe.specs.jsweaver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.jmock.util.NotImplementedException;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jsweaver.abstracts.AJsWeaverJoinPoint;
import pt.up.fe.specs.jsweaver.joinpoints.JsDeclaration;
import pt.up.fe.specs.jsweaver.joinpoints.JsFile;
import pt.up.fe.specs.jsweaver.joinpoints.JsProject;

public class JsJoinpoints {

    private static final Map<String, Function<JsonObject, AJsWeaverJoinPoint>> MAPPINGS;
    static {
        MAPPINGS = new HashMap<>();
        MAPPINGS.put("Project", JsProject::new);
        MAPPINGS.put("Program", JsFile::new);
        MAPPINGS.put("VariableDeclarator", JsDeclaration::new);
    }

    public static AJsWeaverJoinPoint create(JsonObject node) {
        String type = node.get("type").getAsString();

        Function<JsonObject, AJsWeaverJoinPoint> mapper = MAPPINGS.get(type);
        if (mapper == null) {
            throw new NotImplementedException("Join point mappings not implemented for type '" + type + "'");
        }

        return mapper.apply(node);
    }

}
