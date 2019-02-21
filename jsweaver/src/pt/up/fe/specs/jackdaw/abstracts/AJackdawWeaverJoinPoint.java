package pt.up.fe.specs.jackdaw.abstracts;

import java.util.List;

import javax.script.ScriptException;

import org.lara.interpreter.weaver.interf.JoinPoint;
import org.lara.interpreter.weaver.interf.SelectOp;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.ParentMapper;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jsast.JackdawEngine;

/**
 * Abstract class which can be edited by the developer. This class will not be overwritten.
 * 
 * @author Lara Weaver Generator
 */
public abstract class AJackdawWeaverJoinPoint extends AJoinPoint {

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
        JsonObject rootObject = ParentMapper.getRoot(this.getNode());
        AJoinPoint rootJoinpoint = (AJoinPoint) JoinpointCreator.create(rootObject);
        return rootJoinpoint;
    }

    @Override
    public String getTypeImpl() {
        return getNode().get("type").getAsString();
    }

    @Override
    public AJoinPoint getParentImpl() {
        JsonObject parentNode = ParentMapper.getParent(this.getNode());

        parentNode.get("type").getAsString();

        AJoinPoint parentJoinpoint = (AJoinPoint) JoinpointCreator.create(parentNode);
        return parentJoinpoint;
    }

    @Override
    public void insertImpl(String position, String code) {

        try {
            JsonArray statements = JackdawEngine.parseInsertedCode(code);
        } catch (ScriptException error) {
            throw new RuntimeException("Could not parse inserted code.", error);
        }
    }

    @Override
    public <T extends JoinPoint> void insertImpl(String position, T JoinPoint) {
        JsonObject joinpoint = (JsonObject) JoinPoint.getNode();
    }

    @Override
    public Object fieldImpl(String fieldName) {
        getNode().get(fieldName);
        return null;
    }

    /**
     * Generic select function, used by the default select implementations.
     */
    public <T extends AJoinPoint> List<? extends T> select(Class<T> joinPointClass, SelectOp op) {
        throw new RuntimeException(
                "Generic select function not implemented yet. Implement it in order to use the default implementations of select");
    }
}
