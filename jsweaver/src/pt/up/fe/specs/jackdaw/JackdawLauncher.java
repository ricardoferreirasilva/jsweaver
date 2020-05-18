package pt.up.fe.specs.jackdaw;

import org.lara.interpreter.joptions.gui.LaraLauncher;

import larai.LaraI;
import pt.up.fe.specs.util.SpecsLogs;
import pt.up.fe.specs.util.SpecsSystem;

public class JackdawLauncher {

    public static void main(String[] args) {
        SpecsSystem.programStandardInit();
        // System.out.println("PRESS ANY KEY");
        // try {
        // System.in.read();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        boolean success = execute(args);

        // Only exit if GUI is not running
        if (!LaraI.isRunningGui()) {
            int exitValue = success ? 0 : 1;
            SpecsLogs.debug("Calling System.exit() on JackdawLauncher, no running GUI detected");
            System.exit(exitValue);
            // UUID uuid = UUID.randomUUID();
        }

    }

    public static boolean execute(String[] args) {
        return LaraLauncher.launch(args, new JackdawWeaver());
    }
}
