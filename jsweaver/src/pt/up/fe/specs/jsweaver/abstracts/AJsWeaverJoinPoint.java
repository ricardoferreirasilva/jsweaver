package pt.up.fe.specs.jsweaver.abstracts;

import javax.script.ScriptException;

import org.lara.interpreter.weaver.interf.JoinPoint;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jsast.JackdawEngine;
import pt.up.fe.specs.jsweaver.abstracts.joinpoints.AJoinPoint;

/**
 * Abstract class which can be edited by the developer. This class will not be overwritten.
 * 
 * @author Lara Weaver Generator
 */
public abstract class AJsWeaverJoinPoint extends AJoinPoint {

    /**
     * Compares the two join points based on their node reference of the used compiler/parsing tool.<br>
     * This is the default implementation for comparing two join points. <br>
     * <b>Note for developers:</b> A weaver may override this implementation in the editable abstract join point, so the
     * changes are made for all join points, or override this method in specific join points.
     */
    @Override
    public boolean compareNodes(AJoinPoint aJoinPoint) {
        return this.getNode().equals(aJoinPoint.getNode());
    }

    @Override
    public AJoinPoint getRootImpl() {
        return null;
        // return getNode().getRoot();
    }

    @Override
    public String getTypeImpl() {
        return getNode().get("type").getAsString();
    }

    @Override
    public void insertImpl(String position, String code) {

        System.out.println("POSITON:" + position);
        System.out.println("CODE:" + code);
        try {
            JsonArray statements = JackdawEngine.parseInsertedCode(code);
            System.out.println(statements);
        } catch (ScriptException error) {
            throw new RuntimeException("Could not parse inserted code.", error);
        }
    }

    @Override
    public <T extends JoinPoint> void insertImpl(String position, T JoinPoint) {
        System.out.println("POSITON:" + position);
        JsonObject joinpoint = (JsonObject) JoinPoint.getNode();
        System.out.println(joinpoint);
        // super.insertImpl(position, JoinPoint);
    }
}
