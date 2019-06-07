package pt.up.fe.specs.jsast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ast.JsAstResources;
import pt.up.fe.specs.util.lazy.Lazy;

public class JackdawEngine {

	private static final Lazy<ScriptEngine> ESPRIMA_PARSER = Lazy.newInstance(JackdawEngine::initEsprima);

	private static ScriptEngine initEsprima() {
		ScriptEngine javascriptEngine = new ScriptEngineManager().getEngineByName("nashorn");

		try {
			javascriptEngine.eval(JsAstResources.ESPRIMA.read());
			javascriptEngine.eval(JsAstResources.ESCODEGEN.read());
			
		} catch (ScriptException e) {
			throw new RuntimeException("Could not load Esprima parser", e);
		}
		return javascriptEngine;
	}

    public static JsonObject parseSourceCode(Path folderPath) throws IOException, ScriptException {
        JsonParser parser = new JsonParser();
        Path esprimaPath = Paths.get("src/esprima/esprima.js");
        Path esprimaAbsolutePath = esprimaPath.toAbsolutePath();

        // Recursively walk all javascript files in the desired folder.
		List<File> sourceFiles = new ArrayList<>();
		ArrayList<JsonObject> sourceFilesJSON = new ArrayList<>();
        Files.walk(folderPath).filter(path -> !Files.isDirectory(path)).forEach(path -> sourceFiles.add(path.toFile()));

        // Root of the AST tree of several files.
        JsonObject root = new JsonObject();
        root.addProperty("type", "Project");

        JsonArray programs = new JsonArray();
        for (File file : sourceFiles) {
            String extension = getFileExtension(file);
            if (extension.equals("js")) {
				parseJs(parser, esprimaAbsolutePath, programs, file);
            }
        }
        root.add("programs", programs);
        return root;

    }

    public static JsonArray parseFolder(Path folderPath) throws IOException, ScriptException {
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


				parseJs(parser, esprimaAbsolutePath, programs, file);
			}
		}
		return programs;

	}

	private static void parseJs(JsonParser parser, Path esprimaAbsolutePath, JsonArray programs, File file)
			throws IOException, ScriptException {
                String text = new String(Files.readAllBytes(file.toPath()));

		ScriptEngine javascriptEngine = ESPRIMA_PARSER.get();

                javascriptEngine.put("code", text);
                javascriptEngine.put("esprimaPath", esprimaAbsolutePath.toString());

                javascriptEngine.eval(JsAstResources.PARSE_JAVASCRIPT.read());
                String stringAst = (String) javascriptEngine.get("string");
                JsonElement jsonTree = parser.parse(stringAst);
                JsonObject program = jsonTree.getAsJsonObject();
                program.addProperty("path", file.getAbsolutePath());
                programs.add(program);
            }

    public static JsonArray parseFile(File source) throws IOException, ScriptException {
        JsonParser parser = new JsonParser();
        Path esprimaPath = Paths.get("src/esprima/esprima.js");
        Path esprimaAbsolutePath = esprimaPath.toAbsolutePath();

        JsonArray programs = new JsonArray();
        String extension = getFileExtension(source);
        if (extension.equals("js")) {
			parseJs(parser, esprimaAbsolutePath, programs, source);
        }
        return programs;

    }

    public static JsonArray parseInsertedCode(String text) throws ScriptException {
        JsonParser parser = new JsonParser();
		ScriptEngine javascriptEngine = ESPRIMA_PARSER.get();
        javascriptEngine.put("code", text);
        javascriptEngine.eval(JsAstResources.PARSE_JAVASCRIPT.read());
        String stringAst = (String) javascriptEngine.get("string");
        JsonElement jsonTree = parser.parse(stringAst);
        JsonObject program = jsonTree.getAsJsonObject();
        JsonArray statements = program.get("body").getAsJsonArray();
        return statements;
    }

	public static void exportPrograms(JsonArray programs, File outputDir, String escodegenOptions)
			throws ScriptException {
        // JsonParser parser = new JsonParser();
		ScriptEngine javascriptEngine = ESPRIMA_PARSER.get();
        for (JsonElement program : programs) {
            JsonObject programObject = program.getAsJsonObject();
            String programString = programObject.toString();
            javascriptEngine.put("AST_STRING", programString);
			javascriptEngine.put("OPTIONS", escodegenOptions);
            javascriptEngine.eval(JsAstResources.GENERATE_JAVASCRIPT.read());
            String generatedText = (String) javascriptEngine.get("GENERATED_JS");

            String path = programObject.get("path").getAsString();
            File file = new File(path);
            File outputFile = new File(outputDir.getAbsolutePath(), file.getName());
            try {
                PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
                writer.print(generatedText);
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

	public static String codeFromJSON(JsonObject node) throws ScriptException {
		JsonParser parser = new JsonParser();
//		ScriptEngine javascriptEngine = JackdawEngineUtilities.createJavascriptEngine();
		ScriptEngine javascriptEngine = ESPRIMA_PARSER.get();
		String programString = node.toString();
		javascriptEngine.put("AST_STRING", programString);
		javascriptEngine.put("OPTIONS", "{}");
		javascriptEngine.eval(JsAstResources.GENERATE_JAVASCRIPT.read());
		String generatedText = (String) javascriptEngine.get("GENERATED_JS");
		return generatedText;
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