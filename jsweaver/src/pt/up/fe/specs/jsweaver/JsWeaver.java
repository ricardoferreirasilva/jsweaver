package pt.up.fe.specs.jsweaver;

import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.script.ScriptException;

import org.lara.interpreter.weaver.interf.AGear;
import org.lara.interpreter.weaver.interf.JoinPoint;
import org.lara.interpreter.weaver.options.WeaverOption;
import org.lara.language.specification.LanguageSpecification;
import org.suikasoft.jOptions.Interfaces.DataStore;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jsast.JackdawEngine;
import pt.up.fe.specs.jsweaver.abstracts.weaver.AJsWeaver;

/**
 * Weaver Implementation for JsWeaver<br>
 * Since the generated abstract classes are always overwritten, their implementation should be done by extending those
 * abstract classes with user-defined classes.<br>
 * The abstract class {@link pt.up.fe.specs.jsweaver.abstracts.AJsWeaverJoinPoint} can be used to add user-defined
 * methods and fields which the user intends to add for all join points and are not intended to be used in LARA aspects.
 * 
 * @author Lara Weaver Generator
 */
public class JsWeaver extends AJsWeaver {

    private JsonObject project;
    private File outputDir;

    /**
     * Warns the lara interpreter if the weaver accepts a folder as the application or only one file at a time.
     * 
     * @return true if the weaver is able to work with several files, false if only works with one file
     */
    public boolean handlesApplicationFolder() {
        // Can the weaver handle an application folder?
        return true;
    }

    /**
     * Set a file/folder in the weaver if it is valid file/folder type for the weaver.
     * 
     * @param source
     *            the file with the source code
     * @param outputDir
     *            output directory for the generated file(s)
     * @param args
     *            arguments to start the weaver
     * @return true if the file type is valid
     */
    public boolean begin(List<File> sources, File outputDir, DataStore args) {
        if (outputDir.isDirectory() && outputDir.isDirectory()) {
            this.outputDir = outputDir;
        } else {
            throw new RuntimeException("Specified output directory is not valid.");
        }
        JsonArray totalPrograms = new JsonArray();
        for (File source : sources) {
            if (source.exists()) {
                if (source.isDirectory()) {
                    try {
                        JsonArray programs = JackdawEngine.parseFolder(source.toPath());
                        totalPrograms.addAll(programs);
                    } catch (Exception error) {
                        throw new RuntimeException("Could not parse source.", error);
                    }
                } else if (source.isFile()) {
                    try {
                        JsonArray programs = JackdawEngine.parseFile(source);
                        totalPrograms.addAll(programs);
                    } catch (Exception error) {
                        throw new RuntimeException("Could not parse source.", error);
                    }
                } else {
                    throw new RuntimeException("Source type not supported.");
                }
            } else {
                throw new RuntimeException("Source does not exist.");
            }
        }
        JsonObject root = new JsonObject();
        root.addProperty("type", "Project");
        root.add("programs", totalPrograms);
        this.project = root;

        JsonObject rootCopy = root;
        JackdawUtilities.formParents(rootCopy);
        JsonArray queryResult = JackdawQueryEngine.queryNode(root, "VariableDeclaration", true);
        System.out.println("RESULT: " + queryResult);
        return true;
    }

    @Override
    public String getName() {
        return "Jackdaw v0.1";
    }

    /**
     * Return a JoinPoint instance of the language root, i.e., an instance of AProject
     * 
     * @return an instance of the join point root/program
     */
    public JoinPoint select() {
        return JsJoinpoints.create(project);
    }

    /**
     * Closes the weaver to the specified output directory location, if the weaver generates new file(s)
     * 
     * @return if close was successful
     */
    public boolean close() {
        JsonArray programs = this.project.get("programs").getAsJsonArray();
        try {
            JackdawEngine.exportPrograms(programs, this.outputDir);
        } catch (ScriptException e) {
            throw new RuntimeException("Error while outputing Javascript.", e);
        }
        return true;
    }

    /**
     * Returns a list of Gears associated to this weaver engine
     * 
     * @return a list of implementations of {@link AGear} or null if no gears are available
     */
    public List<AGear> getGears() {
        return Collections.emptyList(); // i.e., no gears currently being used
    }

    /**
     * Returns Weaving Engine as a JsWeaver
     */
    public static JsWeaver getJsWeaver() {
        return (JsWeaver) getWeaverStatic();
    }

    private static JsWeaver getWeaverStatic() {
        return (JsWeaver) getThreadLocalWeaver();
    }

    @Override
    public List<WeaverOption> getOptions() {
        return Collections.emptyList();
    }

    @Override
    public LanguageSpecification getLanguageSpecification() {
        return LanguageSpecification.newInstance(() -> "jsweaver/specs/joinPointModel.xml",
                () -> "jsweaver/specs/artifacts.xml", () -> "jsweaver/specs/actionModel.xml", true);

    }

}
