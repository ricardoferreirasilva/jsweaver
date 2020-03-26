package pt.up.fe.specs.jackdaw.abstracts.joinpoints;

import java.util.List;
import org.lara.interpreter.weaver.interf.SelectOp;
import pt.up.fe.specs.jackdaw.abstracts.AJackdawWeaverJoinPoint;
import org.lara.interpreter.weaver.interf.JoinPoint;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Auto-Generated class for join point AScope
 * This class is overwritten by the Weaver Generator.
 * 
 * Represents a code region.
 * @author Lara Weaver Generator
 */
public abstract class AScope extends AJackdawWeaverJoinPoint {

    /**
     * Default implementation of the method used by the lara interpreter to select statements
     * @return 
     */
    public List<? extends AStatement> selectStatement() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select expressionStatements
     * @return 
     */
    public List<? extends AExpressionStatement> selectExpressionStatement() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AExpressionStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select whileStatements
     * @return 
     */
    public List<? extends AWhileStatement> selectWhileStatement() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AWhileStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select whiles
     * @return 
     */
    public List<? extends AWhileStatement> selectWhile() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AWhileStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select doWhileStatements
     * @return 
     */
    public List<? extends ADoWhileStatement> selectDoWhileStatement() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.ADoWhileStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select dos
     * @return 
     */
    public List<? extends AWhileStatement> selectDo() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AWhileStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select ifStatements
     * @return 
     */
    public List<? extends AIfStatement> selectIfStatement() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AIfStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select ifs
     * @return 
     */
    public List<? extends AIfStatement> selectIf() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AIfStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select loops
     * @return 
     */
    public List<? extends ALoop> selectLoop() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.ALoop.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select forStatements
     * @return 
     */
    public List<? extends AForStatement> selectForStatement() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AForStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select fors
     * @return 
     */
    public List<? extends AForStatement> selectFor() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AForStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select tryStatements
     * @return 
     */
    public List<? extends ATryStatement> selectTryStatement() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.ATryStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select trys
     * @return 
     */
    public List<? extends ATryStatement> selectTry() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.ATryStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select switchStatements
     * @return 
     */
    public List<? extends ASwitchStatement> selectSwitchStatement() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.ASwitchStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select switchs
     * @return 
     */
    public List<? extends ASwitchStatement> selectSwitch() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.ASwitchStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select functionDeclarations
     * @return 
     */
    public List<? extends AFunctionDeclaration> selectFunctionDeclaration() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AFunctionDeclaration.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select functions
     * @return 
     */
    public List<? extends AFunctionDeclaration> selectFunction() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AFunctionDeclaration.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select classDeclarations
     * @return 
     */
    public List<? extends AClassDeclaration> selectClassDeclaration() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AClassDeclaration.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select classs
     * @return 
     */
    public List<? extends AClassDeclaration> selectClass() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AClassDeclaration.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select blockStatements
     * @return 
     */
    public List<? extends ABlockStatement> selectBlockStatement() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.ABlockStatement.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select declarations
     * @return 
     */
    public List<? extends ADeclaration> selectDeclaration() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.ADeclaration.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select methodDefinitions
     * @return 
     */
    public List<? extends AMethodDefinition> selectMethodDefinition() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AMethodDefinition.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select expressions
     * @return 
     */
    public List<? extends AExpression> selectExpression() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AExpression.class, SelectOp.DESCENDANTS);
    }

    /**
     * Default implementation of the method used by the lara interpreter to select assignmentExpressions
     * @return 
     */
    public List<? extends AAssignmentExpression> selectAssignmentExpression() {
        return select(pt.up.fe.specs.jackdaw.abstracts.joinpoints.AAssignmentExpression.class, SelectOp.DESCENDANTS);
    }

    /**
     * 
     */
    @Override
    public final List<? extends JoinPoint> select(String selectName) {
        List<? extends JoinPoint> joinPointList;
        switch(selectName) {
        	case "statement": 
        		joinPointList = selectStatement();
        		break;
        	case "expressionStatement": 
        		joinPointList = selectExpressionStatement();
        		break;
        	case "whileStatement": 
        		joinPointList = selectWhileStatement();
        		break;
        	case "while": 
        		joinPointList = selectWhile();
        		break;
        	case "doWhileStatement": 
        		joinPointList = selectDoWhileStatement();
        		break;
        	case "do": 
        		joinPointList = selectDo();
        		break;
        	case "ifStatement": 
        		joinPointList = selectIfStatement();
        		break;
        	case "if": 
        		joinPointList = selectIf();
        		break;
        	case "loop": 
        		joinPointList = selectLoop();
        		break;
        	case "forStatement": 
        		joinPointList = selectForStatement();
        		break;
        	case "for": 
        		joinPointList = selectFor();
        		break;
        	case "tryStatement": 
        		joinPointList = selectTryStatement();
        		break;
        	case "try": 
        		joinPointList = selectTry();
        		break;
        	case "switchStatement": 
        		joinPointList = selectSwitchStatement();
        		break;
        	case "switch": 
        		joinPointList = selectSwitch();
        		break;
        	case "functionDeclaration": 
        		joinPointList = selectFunctionDeclaration();
        		break;
        	case "function": 
        		joinPointList = selectFunction();
        		break;
        	case "classDeclaration": 
        		joinPointList = selectClassDeclaration();
        		break;
        	case "class": 
        		joinPointList = selectClass();
        		break;
        	case "blockStatement": 
        		joinPointList = selectBlockStatement();
        		break;
        	case "declaration": 
        		joinPointList = selectDeclaration();
        		break;
        	case "methodDefinition": 
        		joinPointList = selectMethodDefinition();
        		break;
        	case "expression": 
        		joinPointList = selectExpression();
        		break;
        	case "assignmentExpression": 
        		joinPointList = selectAssignmentExpression();
        		break;
        	default:
        		joinPointList = super.select(selectName);
        		break;
        }
        return joinPointList;
    }

    /**
     * 
     */
    @Override
    public final void defImpl(String attribute, Object value) {
        switch(attribute){
        default: throw new UnsupportedOperationException("Join point "+get_class()+": attribute '"+attribute+"' cannot be defined");
        }
    }

    /**
     * 
     */
    @Override
    protected final void fillWithAttributes(List<String> attributes) {
        super.fillWithAttributes(attributes);
    }

    /**
     * 
     */
    @Override
    protected final void fillWithSelects(List<String> selects) {
        super.fillWithSelects(selects);
        selects.add("statement");
        selects.add("expressionStatement");
        selects.add("whileStatement");
        selects.add("while");
        selects.add("doWhileStatement");
        selects.add("do");
        selects.add("ifStatement");
        selects.add("if");
        selects.add("loop");
        selects.add("forStatement");
        selects.add("for");
        selects.add("tryStatement");
        selects.add("try");
        selects.add("switchStatement");
        selects.add("switch");
        selects.add("functionDeclaration");
        selects.add("function");
        selects.add("classDeclaration");
        selects.add("class");
        selects.add("blockStatement");
        selects.add("declaration");
        selects.add("methodDefinition");
        selects.add("expression");
        selects.add("assignmentExpression");
    }

    /**
     * 
     */
    @Override
    protected final void fillWithActions(List<String> actions) {
        super.fillWithActions(actions);
    }

    /**
     * Returns the join point type of this class
     * @return The join point type
     */
    @Override
    public final String get_class() {
        return "scope";
    }
    /**
     * 
     */
    protected enum ScopeAttributes {
        PARENT("parent"),
        JOINPOINTNAME("joinPointName"),
        AST("ast"),
        CODE("code"),
        LINE("line"),
        ANCESTOR("ancestor"),
        COLUMN("column"),
        TYPE("type"),
        DESCENDANTS("descendants"),
        UUID("uuid"),
        FILE("file"),
        FIELD("field"),
        CHILDREN("children"),
        ROOT("root");
        private String name;

        /**
         * 
         */
        private ScopeAttributes(String name){
            this.name = name;
        }
        /**
         * Return an attribute enumeration item from a given attribute name
         */
        public static Optional<ScopeAttributes> fromString(String name) {
            return Arrays.asList(values()).stream().filter(attr -> attr.name.equals(name)).findAny();
        }

        /**
         * Return a list of attributes in String format
         */
        public static List<String> getNames() {
            return Arrays.asList(values()).stream().map(ScopeAttributes::name).collect(Collectors.toList());
        }

        /**
         * True if the enum contains the given attribute name, false otherwise.
         */
        public static boolean contains(String name) {
            return fromString(name).isPresent();
        }
    }
}
