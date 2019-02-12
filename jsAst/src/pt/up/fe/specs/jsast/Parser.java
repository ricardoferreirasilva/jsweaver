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
    public Parser() {
    }

    public static void main(String[] args) throws ScriptException, IOException, JSONException {
        System.out.println("Started parser.");
        Path testPath = Paths.get("src/examples");
        parseSourceCode(testPath);
    }

    public static void printDirectoryFilenames() {
        File file = new File(".");
        for (String fileNames : file.list())
            System.out.println(fileNames);

    }

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
            String text = new String(Files.readAllBytes(file.toPath()));
            ScriptEngine javascriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
            javascriptEngine.put("code", text);
            javascriptEngine.put("esprimaPath", esprimaAbsolutePath.toString());

            Path scriptPath = Paths.get("src/esprima/esprima.js");
            System.out.println(scriptPath.toAbsolutePath().toString());
            javascriptEngine.eval(JsAstResources.ESPRIMA.read());
            javascriptEngine.eval(JsAstResources.PARSE_JAVASCRIPT.read());
            String stringAst = (String) javascriptEngine.get("string");

            JsonElement jsonTree = parser.parse(stringAst);
            JsonObject program = jsonTree.getAsJsonObject();
            program.addProperty("path", file.getAbsolutePath());
            programs.add(program);
        }
        root.add("programs", programs);
        System.out.println(root);
        return root;
    }
}
