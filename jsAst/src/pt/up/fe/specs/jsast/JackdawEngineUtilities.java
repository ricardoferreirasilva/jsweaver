package pt.up.fe.specs.jsast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import ast.JsAstResources;

public class JackdawEngineUtilities {
    public static ScriptEngine createJavascriptEngine() throws ScriptException {
        ScriptEngine javascriptEngine = loadEngineResources(new ScriptEngineManager().getEngineByName("nashorn"));
        return javascriptEngine;
    }

    private static ScriptEngine loadEngineResources(ScriptEngine engine) throws ScriptException {
        engine.eval(JsAstResources.ESPRIMA.read());
        engine.eval(JsAstResources.ESCODEGEN.read());
        engine.eval(JsAstResources.ESPRIMA_WALK.read());
        return engine;
    }
}
