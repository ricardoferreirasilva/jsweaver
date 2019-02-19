package pt.up.fe.specs.jackdaw;

import org.lara.interpreter.tester.WeaverTester;

import pt.up.fe.specs.jackdaw.JackdawWeaver;

public class JackdawTester extends WeaverTester<JackdawWeaver, JackdawTester> {

    public JackdawTester(String basePackage) {
        super(JackdawWeaver.class, basePackage);
    }

}
