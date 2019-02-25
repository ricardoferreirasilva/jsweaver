package pt.up.fe.specs.jackdaw.tests;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import pt.up.fe.specs.jackdaw.JackdawTester;
import pt.up.fe.specs.util.SpecsSystem;

public class IfStatementTest {

    @BeforeClass
    public static void setupOnce() {
        SpecsSystem.programStandardInit();
        JackdawTester.clean();
    }

    @After
    public void tearDown() {
        JackdawTester.clean();
    }

    private static JackdawTester newTester() {
        return new JackdawTester("jackdaw/tests/")
                .setResultPackage("results")
                .setSrcPackage("src");
    }

    @Test
    public void testFile() {
        newTester().test("IfStatementTest.lara", "test-ifStatement.js");
    }

}
