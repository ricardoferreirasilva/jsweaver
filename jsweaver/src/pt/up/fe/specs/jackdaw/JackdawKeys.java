package pt.up.fe.specs.jackdaw;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.lara.interpreter.weaver.options.OptionArguments;
import org.lara.interpreter.weaver.options.WeaverOption;
import org.lara.interpreter.weaver.options.WeaverOptionBuilder;
import org.suikasoft.jOptions.Datakey.DataKey;
import org.suikasoft.jOptions.Datakey.KeyFactory;
import org.suikasoft.jOptions.storedefinition.StoreDefinition;
import org.suikasoft.jOptions.storedefinition.StoreDefinitionBuilder;

import pt.up.fe.specs.clang.ClangAstKeys;
import pt.up.fe.specs.clang.codeparser.ParallelCodeParser;
import pt.up.fe.specs.clava.ClavaOptions;
import pt.up.fe.specs.clava.language.Standard;
import pt.up.fe.specs.clava.weaver.CxxWeaver;
import pt.up.fe.specs.clava.weaver.options.CxxWeaverOption;

public interface JackdawKeys {

    DataKey<File> ESCODEGEN_CONFIG = KeyFactory.file("escodegenConfig", "json")
            .setLabel("ESCodeGen configuration file");
    
    StoreDefinition STORE_DEFINITION = new StoreDefinitionBuilder("Jackdaw Weaver")
            .addKeys(ESCODEGEN_CONFIG)
            .build();
    
    

}
