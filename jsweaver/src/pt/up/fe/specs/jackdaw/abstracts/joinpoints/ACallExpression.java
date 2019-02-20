package pt.up.fe.specs.jackdaw.abstracts.joinpoints;

import org.lara.interpreter.weaver.interf.events.Stage;
import java.util.Optional;
import org.lara.interpreter.exception.AttributeException;
import javax.script.Bindings;
import java.util.List;
import org.lara.interpreter.weaver.interf.JoinPoint;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Auto-Generated class for join point ACallExpression
 * This class is overwritten by the Weaver Generator.
 * 
 * 
 * @author Lara Weaver Generator
 */
public abstract class ACallExpression extends AExpression {

    protected AExpression aExpression;

    /**
     * 
     */
    public ACallExpression(AExpression aExpression){
        this.aExpression = aExpression;
    }
    /**
     * Identifier of this expression call.
     */
    public abstract AJoinPoint getCalleeImpl();

    /**
     * Identifier of this expression call.
     */
    public final Object getCallee() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "callee", Optional.empty());
        	}
        	AJoinPoint result = this.getCalleeImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "callee", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "callee", e);
        }
    }

    /**
     * Get value on attribute arguments
     * @return the attribute's value
     */
    public abstract AJoinPoint[] getArgumentsArrayImpl();

    /**
     * Arguments of this expression call.
     */
    public Bindings getArgumentsImpl() {
        AJoinPoint[] aJoinPointArrayImpl0 = getArgumentsArrayImpl();
        Bindings nativeArray0 = getWeaverEngine().getScriptEngine().toNativeArray(aJoinPointArrayImpl0);
        return nativeArray0;
    }

    /**
     * Arguments of this expression call.
     */
    public final Object getArguments() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "arguments", Optional.empty());
        	}
        	Bindings result = this.getArgumentsImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "arguments", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "arguments", e);
        }
    }

    /**
     * Method used by the lara interpreter to select callExpressions
     * @return 
     */
    @Override
    public List<? extends ACallExpression> selectCallExpression() {
        return this.aExpression.selectCallExpression();
    }

    /**
     * 
     * @param position 
     * @param code 
     */
    @Override
    public void insertImpl(String position, String code) {
        this.aExpression.insertImpl(position, code);
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return this.aExpression.toString();
    }

    /**
     * 
     */
    @Override
    public Optional<? extends AExpression> getSuper() {
        return Optional.of(this.aExpression);
    }

    /**
     * 
     */
    @Override
    public final List<? extends JoinPoint> select(String selectName) {
        List<? extends JoinPoint> joinPointList;
        switch(selectName) {
        	case "callExpression": 
        		joinPointList = selectCallExpression();
        		break;
        	default:
        		joinPointList = this.aExpression.select(selectName);
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
        this.aExpression.fillWithAttributes(attributes);
        attributes.add("callee");
        attributes.add("arguments");
    }

    /**
     * 
     */
    @Override
    protected final void fillWithSelects(List<String> selects) {
        this.aExpression.fillWithSelects(selects);
    }

    /**
     * 
     */
    @Override
    protected final void fillWithActions(List<String> actions) {
        this.aExpression.fillWithActions(actions);
    }

    /**
     * Returns the join point type of this class
     * @return The join point type
     */
    @Override
    public final String get_class() {
        return "callExpression";
    }

    /**
     * Defines if this joinpoint is an instanceof a given joinpoint class
     * @return True if this join point is an instanceof the given class
     */
    @Override
    public final boolean instanceOf(String joinpointClass) {
        boolean isInstance = get_class().equals(joinpointClass);
        if(isInstance) {
        	return true;
        }
        return this.aExpression.instanceOf(joinpointClass);
    }
    /**
     * 
     */
    protected enum CallExpressionAttributes {
        CALLEE("callee"),
        ARGUMENTS("arguments"),
        PARENT("parent"),
        TYPE("type"),
        FIELD("field"),
        ROOT("root");
        private String name;

        /**
         * 
         */
        private CallExpressionAttributes(String name){
            this.name = name;
        }
        /**
         * Return an attribute enumeration item from a given attribute name
         */
        public static Optional<CallExpressionAttributes> fromString(String name) {
            return Arrays.asList(values()).stream().filter(attr -> attr.name.equals(name)).findAny();
        }

        /**
         * Return a list of attributes in String format
         */
        public static List<String> getNames() {
            return Arrays.asList(values()).stream().map(CallExpressionAttributes::name).collect(Collectors.toList());
        }

        /**
         * True if the enum contains the given attribute name, false otherwise.
         */
        public static boolean contains(String name) {
            return fromString(name).isPresent();
        }
    }
}
