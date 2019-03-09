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
 * Auto-Generated class for join point AClassDeclaration
 * This class is overwritten by the Weaver Generator.
 * 
 * 
 * @author Lara Weaver Generator
 */
public abstract class AClassDeclaration extends AJackdawWeaverJoinPoint {

    /**
     * Identifier of this class
     */
    public abstract AJoinPoint getIdImpl();

    /**
     * Identifier of this class
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
     * superclass of this class
     */
    public abstract AJoinPoint getSuperclassImpl();

    /**
     * superclass of this class
     */
    public final Object getSuperclass() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "superclass", Optional.empty());
        	}
        	AJoinPoint result = this.getSuperclassImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "superclass", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "superclass", e);
        }
    }

    /**
     * Default implementation of the method used by the lara interpreter to select classBodys
     * @return 
     */
    public List<? extends AClassBody> selectClassBody() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AClassBody.class, SelectOp.DESCENDANTS);
    }

    /**
     * 
     */
    @Override
    public final List<? extends JoinPoint> select(String selectName) {
        List<? extends JoinPoint> joinPointList;
        switch(selectName) {
        	case "classBody": 
        		joinPointList = selectClassBody();
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
        attributes.add("superclass");
    }

    /**
     * 
     */
    @Override
    protected final void fillWithSelects(List<String> selects) {
        super.fillWithSelects(selects);
        selects.add("classBody");
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
        return "classDeclaration";
    }
    /**
     * 
     */
    protected enum ClassDeclarationAttributes {
        ID("id"),
        SUPERCLASS("superclass"),
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
        private ClassDeclarationAttributes(String name){
            this.name = name;
        }
        /**
         * Return an attribute enumeration item from a given attribute name
         */
        public static Optional<ClassDeclarationAttributes> fromString(String name) {
            return Arrays.asList(values()).stream().filter(attr -> attr.name.equals(name)).findAny();
        }

        /**
         * Return a list of attributes in String format
         */
        public static List<String> getNames() {
            return Arrays.asList(values()).stream().map(ClassDeclarationAttributes::name).collect(Collectors.toList());
        }

        /**
         * True if the enum contains the given attribute name, false otherwise.
         */
        public static boolean contains(String name) {
            return fromString(name).isPresent();
        }
    }
}
