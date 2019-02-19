package pt.up.fe.specs.jackdaw.abstracts.joinpoints;

import org.lara.interpreter.weaver.interf.events.Stage;

import pt.up.fe.specs.jackdaw.abstracts.AJsWeaverJoinPoint;

import java.util.Optional;
import org.lara.interpreter.exception.AttributeException;
import java.util.List;

import org.lara.interpreter.weaver.interf.JoinPoint;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Auto-Generated class for join point AFile
 * This class is overwritten by the Weaver Generator.
 * 
 * 
 * @author Lara Weaver Generator
 */
public abstract class AFile extends AJsWeaverJoinPoint {

    /**
     * Absolute path of the program file.
     */
    public abstract String getPathImpl();

    /**
     * Absolute path of the program file.
     */
    public final Object getPath() {
        try {
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.BEGIN, this, "path", Optional.empty());
        	}
        	String result = this.getPathImpl();
        	if(hasListeners()) {
        		eventTrigger().triggerAttribute(Stage.END, this, "path", Optional.ofNullable(result));
        	}
        	return result!=null?result:getUndefinedValue();
        } catch(Exception e) {
        	throw new AttributeException(get_class(), "path", e);
        }
    }

    /**
     * Method used by the lara interpreter to select declarations
     * @return 
     */
    public abstract List<? extends ADeclaration> selectDeclaration();

    /**
     * 
     */
    @Override
    public List<? extends JoinPoint> select(String selectName) {
        List<? extends JoinPoint> joinPointList;
        switch(selectName) {
        	case "declaration": 
        		joinPointList = selectDeclaration();
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
        super.fillWithAttributes(attributes);
        attributes.add("path");
    }

    /**
     * 
     */
    @Override
    protected void fillWithSelects(List<String> selects) {
        super.fillWithSelects(selects);
        selects.add("declaration");
    }

    /**
     * 
     */
    @Override
    protected void fillWithActions(List<String> actions) {
        super.fillWithActions(actions);
    }

    /**
     * Returns the join point type of this class
     * @return The join point type
     */
    @Override
    public String get_class() {
        return "file";
    }
    /**
     * 
     */
    protected enum FileAttributes {
        PATH("path"),
        TYPE("type"),
        PARENT("parent"),
        ROOT("root");
        private String name;

        /**
         * 
         */
        private FileAttributes(String name){
            this.name = name;
        }
        /**
         * Return an attribute enumeration item from a given attribute name
         */
        public static Optional<FileAttributes> fromString(String name) {
            return Arrays.asList(values()).stream().filter(attr -> attr.name.equals(name)).findAny();
        }

        /**
         * Return a list of attributes in String format
         */
        public static List<String> getNames() {
            return Arrays.asList(values()).stream().map(FileAttributes::name).collect(Collectors.toList());
        }

        /**
         * True if the enum contains the given attribute name, false otherwise.
         */
        public static boolean contains(String name) {
            return fromString(name).isPresent();
        }
    }
}
