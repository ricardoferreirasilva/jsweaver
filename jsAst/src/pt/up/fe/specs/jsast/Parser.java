package pt.up.fe.specs.jsast;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.json.JSONException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ast.JsAstResources;

public class Parser {
    public static JsonObject parseSourceCode(Path folderPath) throws IOException, ScriptException, JSONException {
        JsonParser parser = new JsonParser();
        Path esprimaPath = Paths.get("src/esprima/esprima.js");
        Path esprimaAbsolutePath = esprimaPath.toAbsolutePath();

        // Recursively walk all javascript files in the desired folder.
        List<File> sourceFiles = new ArrayList<File>();
        List<JsonObject> sourceFilesJSON = new ArrayList<JsonObject>();
        Files.walk(folderPath).filter(path -> !Files.isDirectory(path)).forEach(path -> sourceFiles.add(path.toFile()));

        // Root of the AST tree of several files.
        JsonObject root = new JsonObject();
        root.addProperty("type", "Project");

        JsonArray programs = new JsonArray();
        for (File file : sourceFiles) {
            String extension = getFileExtension(file);
            if (extension.equals("js")) {
                String text = new String(Files.readAllBytes(file.toPath()));
                ScriptEngine javascriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
                javascriptEngine.put("code", text);
                javascriptEngine.put("esprimaPath", esprimaAbsolutePath.toString());

                Path scriptPath = Paths.get("src/esprima/esprima.js");
                javascriptEngine.eval(JsAstResources.ESPRIMA.read());
                javascriptEngine.eval(JsAstResources.ESPRIMA_WALK.read());
                javascriptEngine.eval(JsAstResources.PARSE_JAVASCRIPT.read());
                String stringAst = (String) javascriptEngine.get("string");

                JsonElement jsonTree = parser.parse(stringAst);
                JsonObject program = jsonTree.getAsJsonObject();
                program.addProperty("path", file.getAbsolutePath());
                programs.add(program);
            }
        }
        root.add("programs", programs);
        return root;

    }

    public static JsonArray parseFolder(Path folderPath) throws IOException, ScriptException, JSONException {
        JsonParser parser = new JsonParser();
        Path esprimaPath = Paths.get("src/esprima/esprima.js");
        Path esprimaAbsolutePath = esprimaPath.toAbsolutePath();

        // Recursively walk all javascript files in the desired folder.
        List<File> sourceFiles = new ArrayList<File>();
        List<JsonObject> sourceFilesJSON = new ArrayList<JsonObject>();
        Files.walk(folderPath).filter(path -> !Files.isDirectory(path)).forEach(path -> sourceFiles.add(path.toFile()));

        JsonArray programs = new JsonArray();
        for (File file : sourceFiles) {
            String extension = getFileExtension(file);
            if (extension.equals("js")) {
                String text = new String(Files.readAllBytes(file.toPath()));
                ScriptEngine javascriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
                javascriptEngine.put("code", text);
                javascriptEngine.put("esprimaPath", esprimaAbsolutePath.toString());

                Path scriptPath = Paths.get("src/esprima/esprima.js");
                javascriptEngine.eval(JsAstResources.ESPRIMA.read());
                javascriptEngine.eval(JsAstResources.ESPRIMA_WALK.read());
                javascriptEngine.eval(JsAstResources.PARSE_JAVASCRIPT.read());
                String stringAst = (String) javascriptEngine.get("string");

                JsonElement jsonTree = parser.parse(stringAst);
                JsonObject program = jsonTree.getAsJsonObject();
                program.addProperty("path", file.getAbsolutePath());
                programs.add(program);
            }
        }
        return programs;

    }

    public static JsonArray parseFile(File source) throws IOException, ScriptException, JSONException {
        JsonParser parser = new JsonParser();
        Path esprimaPath = Paths.get("src/esprima/esprima.js");
        Path esprimaAbsolutePath = esprimaPath.toAbsolutePath();

        JsonArray programs = new JsonArray();
        String extension = getFileExtension(source);
        if (extension.equals("js")) {
            String text = new String(Files.readAllBytes(source.toPath()));
            ScriptEngine javascriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
            javascriptEngine.put("code", text);
            javascriptEngine.put("esprimaPath", esprimaAbsolutePath.toString());

            Path scriptPath = Paths.get("src/esprima/esprima.js");
            javascriptEngine.eval(JsAstResources.ESPRIMA.read());
            javascriptEngine.eval(JsAstResources.ESPRIMA_WALK.read());
            javascriptEngine.eval(JsAstResources.PARSE_JAVASCRIPT.read());
            String stringAst = (String) javascriptEngine.get("string");

            JsonElement jsonTree = parser.parse(stringAst);
            JsonObject program = jsonTree.getAsJsonObject();
            program.addProperty("path", source.getAbsolutePath());
            programs.add(program);
        }
        return programs;

    }

    public static JsonArray parseInsertedCode(String text) throws ScriptException {
        JsonParser parser = new JsonParser();
        ScriptEngine javascriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        javascriptEngine.put("code", text);
        javascriptEngine.eval(JsAstResources.ESPRIMA.read());
        javascriptEngine.eval(JsAstResources.ESPRIMA_WALK.read());
        javascriptEngine.eval(JsAstResources.PARSE_JAVASCRIPT.read());
        String stringAst = (String) javascriptEngine.get("string");
        JsonElement jsonTree = parser.parse(stringAst);
        JsonObject program = jsonTree.getAsJsonObject();
        JsonArray statements = program.get("body").getAsJsonArray();
        return statements;
    }

    private static String getFileExtension(File file) {
        if (file == null) {
            return "";
        }
        String name = file.getName();
        int i = name.lastIndexOf('.');
        String ext = i > 0 ? name.substring(i + 1) : "";
        return ext;
    }
}
