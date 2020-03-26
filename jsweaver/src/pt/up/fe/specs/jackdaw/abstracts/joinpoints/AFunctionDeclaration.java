package pt.up.fe.specs.jackdaw.abstracts.joinpoints;

import org.lara.interpreter.weaver.interf.events.Stage;
import java.util.Optional;
import org.lara.interpreter.exception.AttributeException;
import java.util.List;
import org.lara.interpreter.weaver.interf.SelectOp;
import org.lara.interpreter.exception.ActionException;
import pt.up.fe.specs.jackdaw.abstracts.AJackdawWeaverJoinPoint;
import org.lara.interpreter.weaver.interf.JoinPoint;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Auto-Generated class for join point AFunctionDeclaration
 * This class is overwritten by the Weaver Generator.
 * 
 * 
 * @author Lara Weaver Generator
 */
public abstract class AFunctionDeclaration extends AJackdawWeaverJoinPoint {

    /**
     * Identifier of this function.
     */
    public abstract AJoinPoint getIdImpl();

    /**
     * Identifier of this function.
     */
    public final Object getId() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "id", Optional.empty());
        	}
        	AJoinPoint result = this.getIdImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "id", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "id", e);
        }
    }

    /**
     * Name of this function.
     */
    public abstract String getNameImpl();

    /**
     * Name of this function.
     */
    public final Object getName() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "name", Optional.empty());
        	}
        	String result = this.getNameImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "name", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "name", e);
        }
    }

    /**
     * Get value on attribute params
     * @return the attribute's value
     */
    public abstract AJoinPoint[] getParamsArrayImpl();

    /**
     * Parameters of this function.
     */
    public Object getParamsImpl() {
        AJoinPoint[] aJoinPointArrayImpl0 = getParamsArrayImpl();
        Object nativeArray0 = getWeaverEngine().getScriptEngine().toNativeArray(aJoinPointArrayImpl0);
        return nativeArray0;
    }

    /**
     * Parameters of this function.
     */
    public final Object getParams() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "params", Optional.empty());
        	}
        	Object result = this.getParamsImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "params", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "params", e);
        }
    }

    /**
     * If the function is async.
     */
    public abstract Boolean getAsyncImpl();

    /**
     * If the function is async.
     */
    public final Object getAsync() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "async", Optional.empty());
        	}
        	Boolean result = this.getAsyncImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "async", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "async", e);
        }
    }

    /**
     * 
     */
    public abstract Boolean getGeneratorImpl();

    /**
     * 
     */
    public final Object getGenerator() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "generator", Optional.empty());
        	}
        	Boolean result = this.getGeneratorImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "generator", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "generator", e);
        }
    }

    /**
     * 
     */
    public abstract Boolean getExpressionImpl();

    /**
     * 
     */
    public final Object getExpression() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "expression", Optional.empty());
        	}
        	Boolean result = this.getExpressionImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "expression", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "expression", e);
        }
    }

    /**
     * Default implementation of the method used by the lara interpreter to select blockStatements
     * @return 
     */
    public List<? extends ABlockStatement> selectBlockStatement() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.ABlockStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Refactor this function
     * @param name 
     */
    public void refactorImpl(String name) {
        throw new UnsupportedOperationException(get_class()+": Action refactor not implemented ");
    }

    /**
     * Refactor this function
     * @param name 
     */
    public final void refactor(String name) {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.BEGIN, "refactor", this, Optional.empty(), name);
        	}
        	this.refactorImpl(name);
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.END, "refactor", this, Optional.empty(), name);
        	}
        } catch(Exception e) {
        	throw new ActionException(get_class(), "refactor", e);
        }
    }

    /**
     * Refactor this function
     * @param index 
     * @param name 
     */
    public void refactorParamImpl(int index, String name) {
        throw new UnsupportedOperationException(get_class()+": Action refactorParam not implemented ");
    }

    /**
     * Refactor this function
     * @param index 
     * @param name 
     */
    public final void refactorParam(int index, String name) {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.BEGIN, "refactorParam", this, Optional.empty(), index, name);
        	}
        	this.refactorParamImpl(index, name);
        	if(hasListeners()) {
        		eventTrigger().triggerAction(Stage.END, "refactorParam", this, Optional.empty(), index, name);
        	}
        } catch(Exception e) {
        	throw new ActionException(get_class(), "refactorParam", e);
        }
    }

    /**
     * 
     */
    @Override
    public final List<? extends JoinPoint> select(String selectName) {
        List<? extends JoinPoint> joinPointList;
        switch(selectName) {
        	case "blockStatement": 
        		joinPointList = selectBlockStatement();
        		break;
        	default:
        		joinPointList = super.select(selectName);
        		break;
        }
        return joinPointList;
    }

    /**
     * 
     */
    @Override
    public final void defImpl(String attribute, Object value) {
        switch(attribute){
        default: throw new UnsupportedOperationException("Join point "+get_class()+": attribute '"+attribute+"' cannot be defined");
        }
    }

    /**
     * 
     */
    @Override
    protected final void fillWithAttributes(List<String> attributes) {
        super.fillWithAttributes(attributes);
        attributes.add("id");
        attributes.add("name");
        attributes.add("params");
        attributes.add("async");
        attributes.add("generator");
        attributes.add("expression");
    }

    /**
     * 
     */
    @Override
    protected final void fillWithSelects(List<String> selects) {
        super.fillWithSelects(selects);
        selects.add("blockStatement");
    }

    /**
     * 
     */
    @Override
    protected final void fillWithActions(List<String> actions) {
        super.fillWithActions(actions);
        actions.add("void refactor(string)");
        actions.add("void refactorParam(int, string)");
    }

    /**
     * Returns the join point type of this class
     * @return The join point type
     */
    @Override
    public final String get_class() {
        return "functionDeclaration";
    }
    /**
     * 
     */
    protected enum FunctionDeclarationAttributes {
        ID("id"),
        NAME("name"),
        PARAMS("params"),
        ASYNC("async"),
        GENERATOR("generator"),
        EXPRESSION("expression"),
        PARENT("parent"),
        JOINPOINTNAME("joinPointName"),
        AST("ast"),
        CODE("code"),
        LINE("line"),
        ANCESTOR("ancestor"),
        COLUMN("column"),
        TYPE("type"),
        DESCENDANTS("descendants"),
        UUID("uuid"),
        FILE("file"),
        FIELD("field"),
        CHILDREN("children"),
        ROOT("root");
        private String name;

        /**
         * 
         */
        private FunctionDeclarationAttributes(String name){
            this.name = name;
        }
        /**
         * Return an attribute enumeration item from a given attribute name
         */
        public static Optional<FunctionDeclarationAttributes> fromString(String name) {
            return Arrays.asList(values()).stream().filter(attr -> attr.name.equals(name)).findAny();
        }

        /**
         * Return a list of attributes in String format
         */
        public static List<String> getNames() {
            return Arrays.asList(values()).stream().map(FunctionDeclarationAttributes::name).collect(Collectors.toList());
        }

        /**
         * True if the enum contains the given attribute name, false otherwise.
         */
        public static boolean contains(String name) {
            return fromString(name).isPresent();
        }
    }
}
