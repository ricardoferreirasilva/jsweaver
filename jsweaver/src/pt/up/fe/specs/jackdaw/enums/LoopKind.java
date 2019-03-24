package pt.up.fe.specs.jackdaw.enums;

import org.lara.interpreter.weaver.interf.NamedEnum;
import pt.up.fe.specs.util.lazy.Lazy;
import pt.up.fe.specs.util.enums.EnumHelperWithValue;

/**
 * 
 * 
 * @author Lara C.
 */
public enum LoopKind  implements NamedEnum{
    FOR("for"),
    WHILE("while"),
	DO("do");
    private String name;
    private static final Lazy<EnumHelperWithValue<LoopKind>> ENUM_HELPER = EnumHelperWithValue.newLazyHelperWithValue(LoopKind.class);

    /**
     * 
     */
    private LoopKind(String name){
        this.name = name;
    }
    /**
     * 
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     */
    public String toString() {
        return getName();
    }

    /**
     * 
     */
    public static EnumHelperWithValue<LoopKind> getHelper() {
        return ENUM_HELPER.get();
    }
}
