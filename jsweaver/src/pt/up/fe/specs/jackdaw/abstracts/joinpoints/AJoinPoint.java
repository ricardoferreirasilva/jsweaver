package pt.up.fe.specs.jackdaw.abstracts.joinpoints;

import org.lara.interpreter.weaver.interf.JoinPoint;
import com.google.gson.JsonObject;
import java.util.List;
import org.lara.interpreter.weaver.interf.events.Stage;
import java.util.Optional;
import org.lara.interpreter.exception.AttributeException;
import pt.up.fe.specs.jackdaw.JackdawWeaver;
import org.lara.interpreter.weaver.interf.SelectOp;

/**
 * Abstract class containing the global attributes and default action exception.
 * This class is overwritten when the weaver generator is executed.
 * @author Lara Weaver Generator
 */
public abstract class AJoinPoint extends JoinPoint {

    /**
     * 
     */
    @Override
    public boolean same(JoinPoint iJoinPoint) {
        if (this.get_class().equals(iJoinPoint.get_class())) {
        
                return this.compareNodes((AJoinPoint) iJoinPoint);
            }
            return false;
    }

    /**
     * Compares the two join points based on their node reference of the used compiler/parsing tool.<br>
     * This is the default implementation for comparing two join points. <br>
     * <b>Note for developers:</b> A weaver may override this implementation in the editable abstract join point, so
     * the changes are made for all join points, or override this method in specific join points.
     */
    public boolean compareNodes(AJoinPoint aJoinPoint) {
        return this.getNode().equals(aJoinPoint.getNode());
    }

    /**
     * Returns the tree node reference of this join point.<br><b>NOTE</b>This method is essentially used to compare two join points
     * @return Tree node reference
     */
    public abstract JsonObject getNode();

    /**
     * 
     */
    @Override
    public void defImpl(String attribute, Object value) {
        switch(attribute){
        default: throw new UnsupportedOperationException("Join point "+get_class()+": attribute '"+attribute+"' cannot be defined");
        }
    }

    /**
     * 
     */
    @Override
    protected void fillWithAttributes(List<String> attributes) {
        //Attributes available for all join points
        attributes.add("root");
        attributes.add("parent");
        attributes.add("type");
        attributes.add("field(String fieldName)");
        attributes.add("joinPointName");
        attributes.add("ast");
    }

    /**
     * Returns the 'project' joinpoint
     */
    public abstract AJoinPoint getRootImpl();

    /**
     * Returns the 'project' joinpoint
     */
    public final Object getRoot() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "root", Optional.empty());
        	}
        	AJoinPoint result = this.getRootImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "root", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "root", e);
        }
    }

    /**
     * Returns the 'parent' node of this joinpoint
     */
    public abstract AJoinPoint getParentImpl();

    /**
     * Returns the 'parent' node of this joinpoint
     */
    public final Object getParent() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "parent", Optional.empty());
        	}
        	AJoinPoint result = this.getParentImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "parent", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "parent", e);
        }
    }

    /**
     * The type of the join point
     */
    public abstract String getTypeImpl();

    /**
     * The type of the join point
     */
    public final Object getType() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "type", Optional.empty());
        	}
        	String result = this.getTypeImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "type", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "type", e);
        }
    }

    /**
     * 
     * @param fieldName
     * @return 
     */
    public abstract Object fieldImpl(String fieldName);

    /**
     * 
     * @param fieldName
     * @return 
     */
    public final Object field(String fieldName) {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "field", Optional.empty(), fieldName);
        	}
        	Object result = this.fieldImpl(fieldName);
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "field", Optional.ofNullable(result), fieldName);
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "field", e);
        }
    }

    /**
     * The name of the join point.
     */
    public abstract String getJoinPointNameImpl();

    /**
     * The name of the join point.
     */
    public final Object getJoinPointName() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "joinPointName", Optional.empty());
        	}
        	String result = this.getJoinPointNameImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "joinPointName", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "joinPointName", e);
        }
    }

    /**
     * The ast corresponding to this join point
     */
    public abstract String getAstImpl();

    /**
     * The ast corresponding to this join point
     */
    public final Object getAst() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "ast", Optional.empty());
        	}
        	String result = this.getAstImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "ast", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "ast", e);
        }
    }

    /**
     * Defines if this joinpoint is an instanceof a given joinpoint class
     * @return True if this join point is an instanceof the given class
     */
    @Override
    public boolean instanceOf(String joinpointClass) {
        boolean isInstance = get_class().equals(joinpointClass);
        if(isInstance) {
        	return true;
        }
        return super.instanceOf(joinpointClass);
    }

    /**
     * Returns the Weaving Engine this join point pertains to.
     */
    @Override
    public JackdawWeaver getWeaverEngine() {
        return JackdawWeaver.getJackdawWeaver();
    }

    /**
     * Generic select function, used by the default select implementations.
     */
    public abstract <T extends AJoinPoint> List<? extends T> select(Class<T> joinPointClass, SelectOp op);
}
