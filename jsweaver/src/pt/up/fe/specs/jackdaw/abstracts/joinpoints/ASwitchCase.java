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
 * Auto-Generated class for join point ASwitchCase
 * This class is overwritten by the Weaver Generator.
 * 
 * 
 * @author Lara Weaver Generator
 */
public abstract class ASwitchCase extends AJackdawWeaverJoinPoint {

    /**
     * Test value of this switch case.
     */
    public abstract AJoinPoint getTestImpl();

    /**
     * Test value of this switch case.
     */
    public final Object getTest() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "test", Optional.empty());
        	}
        	AJoinPoint result = this.getTestImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "test", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "test", e);
        }
    }

    /**
     * Default implementation of the method used by the lara interpreter to select scopes
     * @return 
     */
    public List<? extends AScope> selectScope() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AScope.class, SelectOp.DESCENDANTS);
    }

    /**
     * 
     */
    @Override
    public final List<? extends JoinPoint> select(String selectName) {
        List<? extends JoinPoint> joinPointList;
        switch(selectName) {
        	case "scope": 
        		joinPointList = selectScope();
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
        attributes.add("test");
    }

    /**
     * 
     */
    @Override
    protected final void fillWithSelects(List<String> selects) {
        super.fillWithSelects(selects);
        selects.add("scope");
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
        return "switchCase";
    }
    /**
     * 
     */
    protected enum SwitchCaseAttributes {
        TEST("test"),
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
        private SwitchCaseAttributes(String name){
            this.name = name;
        }
        /**
         * Return an attribute enumeration item from a given attribute name
         */
        public static Optional<SwitchCaseAttributes> fromString(String name) {
            return Arrays.asList(values()).stream().filter(attr -> attr.name.equals(name)).findAny();
        }

        /**
         * Return a list of attributes in String format
         */
        public static List<String> getNames() {
            return Arrays.asList(values()).stream().map(SwitchCaseAttributes::name).collect(Collectors.toList());
        }

        /**
         * True if the enum contains the given attribute name, false otherwise.
         */
        public static boolean contains(String name) {
            return fromString(name).isPresent();
        }
    }
}
