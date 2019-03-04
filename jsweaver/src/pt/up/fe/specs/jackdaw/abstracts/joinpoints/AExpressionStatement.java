package pt.up.fe.specs.jackdaw.abstracts.joinpoints;

import org.lara.interpreter.weaver.interf.events.Stage;
import java.util.Optional;
import org.lara.interpreter.exception.AttributeException;
import java.util.List;
import org.lara.interpreter.weaver.interf.SelectOp;
import pt.up.fe.specs.jackdaw.abstracts.AJackdawWeaverJoinPoint;
import org.lara.interpreter.weaver.interf.JoinPoint;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Auto-Generated class for join point AExpressionStatement
 * This class is overwritten by the Weaver Generator.
 * 
 * 
 * @author Lara Weaver Generator
 */
public abstract class AExpressionStatement extends AJackdawWeaverJoinPoint {

    /**
     * Directive of this expression statement.
     */
    public abstract String getDirectiveImpl();

    /**
     * Directive of this expression statement.
     */
    public final Object getDirective() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "directive", Optional.empty());
        	}
        	String result = this.getDirectiveImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "directive", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "directive", e);
        }
    }

    /**
     * Default implementation of the method used by the lara interpreter to select callExpressions
     * @return 
     */
    public List<? extends ACallExpression> selectCallExpression() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.ACallExpression.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select calls
     * @return 
     */
    public List<? extends ACallExpression> selectCall() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.ACallExpression.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select assignmentExpressions
     * @return 
     */
    public List<? extends AAssignmentExpression> selectAssignmentExpression() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AAssignmentExpression.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select updateExpressions
     * @return 
     */
    public List<? extends AUpdateExpression> selectUpdateExpression() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AUpdateExpression.class, SelectOp.DESCENDANTS);
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
        	case "call": 
        		joinPointList = selectCall();
        		break;
        	case "assignmentExpression": 
        		joinPointList = selectAssignmentExpression();
        		break;
        	case "updateExpression": 
        		joinPointList = selectUpdateExpression();
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
        attributes.add("directive");
    }

    /**
     * 
     */
    @Override
    protected final void fillWithSelects(List<String> selects) {
        super.fillWithSelects(selects);
        selects.add("callExpression");
        selects.add("call");
        selects.add("assignmentExpression");
        selects.add("updateExpression");
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
        return "expressionStatement";
    }
    /**
     * 
     */
    protected enum ExpressionStatementAttributes {
        DIRECTIVE("directive"),
        PARENT("parent"),
        JOINPOINTNAME("joinPointName"),
        AST("ast"),
        TYPE("type"),
        FIELD("field"),
        ROOT("root");
        private String name;

        /**
         * 
         */
        private ExpressionStatementAttributes(String name){
            this.name = name;
        }
        /**
         * Return an attribute enumeration item from a given attribute name
         */
        public static Optional<ExpressionStatementAttributes> fromString(String name) {
            return Arrays.asList(values()).stream().filter(attr -> attr.name.equals(name)).findAny();
        }

        /**
         * Return a list of attributes in String format
         */
        public static List<String> getNames() {
            return Arrays.asList(values()).stream().map(ExpressionStatementAttributes::name).collect(Collectors.toList());
        }

        /**
         * True if the enum contains the given attribute name, false otherwise.
         */
        public static boolean contains(String name) {
            return fromString(name).isPresent();
        }
    }
}
