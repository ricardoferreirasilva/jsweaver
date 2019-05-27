package pt.up.fe.specs.jackdaw;

import java.util.HashMap;
import java.util.Map;

import org.lara.interpreter.weaver.options.OptionArguments;
import org.lara.interpreter.weaver.options.WeaverOption;
import org.lara.interpreter.weaver.options.WeaverOptionBuilder;
import org.suikasoft.jOptions.Datakey.DataKey;

import pt.up.fe.specs.util.SpecsLogs;

public class JackdawWeaverOptions {

	private static final Map<String, WeaverOption> WEAVER_OPTIONS;
    static {
        WEAVER_OPTIONS = new HashMap<>();

        addOneArgOption(JackdawKeys.ESCODEGEN_CONFIG, "ec", "escodegen", "codegen config",
                "JSON file with output source configuration in ESCodeGen format");

       
    }
    
    private static void addOneArgOption(DataKey<?> key, String shortOption, String longOption, String argName,
            String description) {

        WEAVER_OPTIONS.put(key.getName(),
                WeaverOptionBuilder.build(shortOption, longOption, OptionArguments.ONE_ARG, argName, description, key));

    }
    
    public static WeaverOption getOption(DataKey<?> key) {
        WeaverOption option = WEAVER_OPTIONS.get(key.getName());
        if (option != null) {
            return option;
        }

        SpecsLogs.msgWarn("Key '" + key + "' is not defined in class 'WEAVER_OPTIONS'");

        return WeaverOptionBuilder.build(key);
    }
}
