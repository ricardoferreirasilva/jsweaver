package pt.up.fe.specs.jackdaw;

import java.io.File;

import org.suikasoft.jOptions.Datakey.DataKey;
import org.suikasoft.jOptions.Datakey.KeyFactory;
import org.suikasoft.jOptions.storedefinition.StoreDefinition;
import org.suikasoft.jOptions.storedefinition.StoreDefinitionBuilder;

public interface JackdawKeys {

    DataKey<File> ESCODEGEN_CONFIG = KeyFactory.file("escodegenConfig", "json")
            .setLabel("ESCodeGen configuration file");

    StoreDefinition STORE_DEFINITION = new StoreDefinitionBuilder("Jackdaw Weaver")
            .addKeys(ESCODEGEN_CONFIG)
            .build();

}
