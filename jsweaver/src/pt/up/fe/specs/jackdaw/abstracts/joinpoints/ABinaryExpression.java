package pt.up.fe.specs.jackdaw.abstracts.joinpoints;

import org.lara.interpreter.weaver.interf.events.Stage;
import java.util.Optional;
import org.lara.interpreter.exception.AttributeException;
import pt.up.fe.specs.jackdaw.abstracts.AJackdawWeaverJoinPoint;
import java.util.List;
import org.lara.interpreter.weaver.interf.JoinPoint;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Auto-Generated class for join point ABinaryExpression
 * This class is overwritten by the Weaver Generator.
 * 
 * 
 * @author Lara Weaver Generator
 */
public abstract class ABinaryExpression extends AJackdawWeaverJoinPoint {

    /**
     * Operator of the binary expression.
     */
    public abstract String getOperatorImpl();

    /**
     * Operator of the binary expression.
     */
    public final Object getOperator() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "operator", Optional.empty());
        	}
        	String result = this.getOperatorImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "operator", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "operator", e);
        }
    }

    /**
     * Left part of the binary expression.
     */
    public abstract AJoinPoint getLeftImpl();

    /**
     * Left part of the binary expression.
     */
    public final Object getLeft() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "left", Optional.empty());
        	}
        	AJoinPoint result = this.getLeftImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "left", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "left", e);
        }
    }

    /**
     * Expression of the binary expression.
     */
    public abstract AJoinPoint getRightImpl();

    /**
     * Expression of the binary expression.
     */
    public final Object getRight() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "right", Optional.empty());
        	}
        	AJoinPoint result = this.getRightImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "right", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "right", e);
        }
    }

    /**
     * 
     */
    @Override
    public final List<? extends JoinPoint> select(String selectName) {
        List<? extends JoinPoint> joinPointList;
        switch(selectName) {
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
        attributes.add("operator");
        attributes.add("left");
        attributes.add("right");
    }

    /**
     * 
     */
    @Override
    protected final void fillWithSelects(List<String> selects) {
        super.fillWithSelects(selects);
    }

    /**
     * 
     */
    @Override
    protected final void fillWithActions(List<String> actions) {
        super.fillWithActions(actions);
    }

    /**
     * Returns the join point type of this class
     * @return The join point type
     */
    @Override
    public final String get_class() {
        return "binaryExpression";
    }
    /**
     * 
     */
    protected enum BinaryExpressionAttributes {
        OPERATOR("operator"),
        LEFT("left"),
        RIGHT("right"),
        PARENT("parent"),
        JOINPOINTNAME("joinPointName"),
        AST("ast"),
        FIELD("field"),
        CHILDREN("children"),
        ROOT("root"),
        TYPE("type"),
        DESCENDANTS("descendants");
        private String name;

        /**
         * 
         */
        private BinaryExpressionAttributes(String name){
            this.name = name;
        }
        /**
         * Return an attribute enumeration item from a given attribute name
         */
        public static Optional<BinaryExpressionAttributes> fromString(String name) {
            return Arrays.asList(values()).stream().filter(attr -> attr.name.equals(name)).findAny();
        }

        /**
         * Return a list of attributes in String format
         */
        public static List<String> getNames() {
            return Arrays.asList(values()).stream().map(BinaryExpressionAttributes::name).collect(Collectors.toList());
        }

        /**
         * True if the enum contains the given attribute name, false otherwise.
         */
        public static boolean contains(String name) {
            return fromString(name).isPresent();
        }
    }
}
