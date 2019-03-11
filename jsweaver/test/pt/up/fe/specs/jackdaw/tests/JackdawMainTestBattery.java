package pt.up.fe.specs.jackdaw.tests;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import pt.up.fe.specs.jackdaw.JackdawTester;
import pt.up.fe.specs.util.SpecsSystem;

public class JackdawMainTestBattery {

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
        newTester().test("File.lara", "file.js");
    }

    @Test
    public void testIf() {
        newTester().test("IfStatementTest.lara", "test-ifStatement.js");
    }

    @Test
    public void testInsert() {
        newTester().test("Insert.lara", "insert.js");
    }

    @Test
    public void classTest() {
        newTester().test("Class.lara", "class.js");
    }
    @Test
    public void testWhile() {
        newTester().test("WhileStatement.lara", "whileStatement.js");
    }
    @Test
    public void testFor() {
        newTester().test("ForStatement.lara", "for.js");
    }
    @Test
    public void testSwitch() {
        newTester().test("Switch.lara", "switch.js");
    }
    @Test
    public void testTryCatch() {
        newTester().test("Try.lara", "try.js");
    }
    @Test
    public void testExpressionStatements() {
        newTester().test("ExpressionStatements.lara", "expression.js");
    }
    @Test
    public void joinPointsBase() {
        newTester().test("JoinPoints.lara", "joinpoints.js");
    }
    @Test
    public void renameTest() {
        newTester().test("Rename.lara", "rename.js");
    }
    

}
