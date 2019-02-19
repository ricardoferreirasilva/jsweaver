package pt.up.fe.specs.jackdaw.abstracts.joinpoints;

import java.util.List;
import java.util.Optional;
import org.lara.interpreter.weaver.interf.JoinPoint;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Auto-Generated class for join point ABase
 * This class is overwritten by the Weaver Generator.
 * 
 * 
 * @author Lara Weaver Generator
 */
public abstract class ABase extends AFile {

    protected AFile aFile;

    /**
     * 
     */
    public ABase(AFile aFile){
        this.aFile = aFile;
    }
    /**
     * Get value on attribute path
     * @return the attribute's value
     */
    @Override
    public String getPathImpl() {
        return this.aFile.getPathImpl();
    }

    /**
     * Method used by the lara interpreter to select declarations
     * @return 
     */
    @Override
    public List<? extends ADeclaration> selectDeclaration() {
        return this.aFile.selectDeclaration();
    }

    /**
     * 
     * @param position 
     * @param code 
     */
    @Override
    public void insertImpl(String position, String code) {
        this.aFile.insertImpl(position, code);
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return this.aFile.toString();
    }

    /**
     * 
     */
    @Override
    public Optional<? extends AFile> getSuper() {
        return Optional.of(this.aFile);
    }

    /**
     * 
     */
    @Override
    public final List<? extends JoinPoint> select(String selectName) {
        List<? extends JoinPoint> joinPointList;
        switch(selectName) {
        	case "declaration": 
        		joinPointList = selectDeclaration();
        		break;
        	default:
        		joinPointList = this.aFile.select(selectName);
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
        this.aFile.fillWithAttributes(attributes);
    }

    /**
     * 
     */
    @Override
    protected final void fillWithSelects(List<String> selects) {
        this.aFile.fillWithSelects(selects);
    }

    /**
     * 
     */
    @Override
    protected final void fillWithActions(List<String> actions) {
        this.aFile.fillWithActions(actions);
    }

    /**
     * Returns the join point type of this class
     * @return The join point type
     */
    @Override
    public final String get_class() {
        return "base";
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
        return this.aFile.instanceOf(joinpointClass);
    }
    /**
     * 
     */
    protected enum BaseAttributes {
        PATH("path"),
        TYPE("type"),
        PARENT("parent"),
        ROOT("root");
        private String name;

        /**
         * 
         */
        private BaseAttributes(String name){
            this.name = name;
        }
        /**
         * Return an attribute enumeration item from a given attribute name
         */
        public static Optional<BaseAttributes> fromString(String name) {
            return Arrays.asList(values()).stream().filter(attr -> attr.name.equals(name)).findAny();
        }

        /**
         * Return a list of attributes in String format
         */
        public static List<String> getNames() {
            return Arrays.asList(values()).stream().map(BaseAttributes::name).collect(Collectors.toList());
        }

        /**
         * True if the enum contains the given attribute name, false otherwise.
         */
        public static boolean contains(String name) {
            return fromString(name).isPresent();
        }
    }
}
