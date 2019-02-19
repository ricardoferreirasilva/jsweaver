package pt.up.fe.specs.jackdaw;

import org.lara.interpreter.joptions.gui.LaraLauncher;

import larai.LaraI;
import pt.up.fe.specs.util.SpecsLogs;
import pt.up.fe.specs.util.SpecsSystem;

public class JseaverLauncher {

    public static void main(String[] args) {
        SpecsSystem.programStandardInit();

        boolean success = execute(args);

        // Only exit if GUI is not running
        if (!LaraI.isRunningGui()) {
            int exitValue = success ? 0 : 1;
            SpecsLogs.debug("Calling System.exit() on ClavaWeaverLauncher, no running GUI detected");
            System.exit(exitValue);
        }

    }

    private static boolean execute(String[] args) {
        return LaraLauncher.launch(args, new JackdawWeaver());

    }
}
