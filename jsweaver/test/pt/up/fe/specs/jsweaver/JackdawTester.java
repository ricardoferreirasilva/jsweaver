package pt.up.fe.specs.jsweaver;

import org.lara.interpreter.tester.WeaverTester;

public class JackdawTester extends WeaverTester<JsWeaver, JackdawTester> {

    public JackdawTester(String basePackage) {
        super(JsWeaver.class, basePackage);
    }

}
