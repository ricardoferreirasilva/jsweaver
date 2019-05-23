package pt.up.fe.specs.jackdaw.abstracts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.script.ScriptException;

import org.lara.interpreter.weaver.interf.JoinPoint;
import org.lara.interpreter.weaver.interf.SelectOp;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JackdawInserter;
import pt.up.fe.specs.jackdaw.JackdawQueryEngine;
import pt.up.fe.specs.jackdaw.JackdawUtilities;
import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.ParentMapper;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jackdaw.joinpoints.JsScope;
import pt.up.fe.specs.jsast.JackdawEngine;
import pt.up.fe.specs.util.lazy.Lazy;

/**
 * Abstract class which can be edited by the developer. This class will not be
 * overwritten.
 * 
 * @author Lara Weaver Generator
 */
public abstract class AJackdawWeaverJoinPoint extends AJoinPoint {

	private final Lazy<String> id = Lazy.newInstance(() -> UUID.randomUUID().toString());

	/**
	 * Compares the two join points based on their node reference of the used
	 * compiler/parsing tool.<br>
	 * This is the default implementation for comparing two join points. <br>
	 * <b>Note for developers:</b> A weaver may override this implementation in the
	 * editable abstract join point, so the changes are made for all join points, or
	 * override this method in specific join points.
	 */
	@Override
	public boolean compareNodes(AJoinPoint aJoinPoint) {
		return this.getNode().equals(aJoinPoint.getNode());
	}

	@Override
	public AJoinPoint getRootImpl() {
		JsonObject rootObject = ParentMapper.getRoot(this.getNode());
		AJoinPoint rootJoinpoint = (AJoinPoint) JoinpointCreator.create(rootObject);
		return rootJoinpoint;
	}
	@Override
	public AJoinPoint getFileImpl() {
		JsonObject fileObject = ParentMapper.getFile(this.getNode());
		AJoinPoint fileJoinpoint = (AJoinPoint) JoinpointCreator.create(fileObject);
		return fileJoinpoint;
	}
	@Override
	public String getTypeImpl() {
		return getNode().get("type").getAsString();
	}

	@Override
	public AJoinPoint getParentImpl() {
		JsonObject parentNode = ParentMapper.getParent(this.getNode());

		parentNode.get("type").getAsString();

		AJoinPoint parentJoinpoint = (AJoinPoint) JoinpointCreator.create(parentNode);
		return parentJoinpoint;
	}

	@Override
	public void insertImpl(String position, String code) {
		List<JoinPoint> stmts = new ArrayList<>();
		try {
			JsonArray statements = JackdawEngine.parseInsertedCode(code);
			JackdawInserter.insertStatements(this.getNode(), statements, position);
			/*
			for(JsonElement element : statements) {
				stmts.add(JoinpointCreator.create(element.getAsJsonObject()));

			}
			*/

		} catch (ScriptException error) {
			throw new RuntimeException("Could not parse inserted code.", error);
		}
		//return (JoinPoint[]) stmts.toArray();
		ParentMapper.setDirty();
	}

	@Override
	public <T extends JoinPoint> void insertImpl(String position, T JoinPoint) {
		JsonObject joinpoint = (JsonObject) JoinPoint.getNode();
		JackdawInserter.insertJoinPoint(this.getNode(), joinpoint, position);
		ParentMapper.setDirty();

	}

	@Override
	public Object fieldImpl(String fieldName) {
		JsonElement field = getNode().get(fieldName);
		if(field.isJsonObject() && field.getAsJsonObject().has("type")) {
			return JoinpointCreator.create(field.getAsJsonObject());
		}
		else if(field.isJsonArray()) {
			List<JoinPoint> foundElements = new ArrayList<>();
			for(JsonElement element : field.getAsJsonArray()) {
				foundElements.add(JoinpointCreator.create(element.getAsJsonObject()));
				
			}
			return foundElements;
			
		}
		else return field;
	}

	/**
	 * Generic select function, used by the default select implementations.
	 */
	public <T extends AJoinPoint> List<? extends T> select(Class<T> joinPointClass, SelectOp op) {

		// For scopes.
		if (joinPointClass.getSimpleName().equals("AScope")) {
			return Arrays.asList(joinPointClass.cast(new JsScope(getNode())));
		}

		return JackdawQueryEngine.queryNodeGeneric(getNode(), joinPointClass, true);

	}

	@Override
	public String getJoinPointNameImpl() {
		return getJoinPointType();
	}

	@Override
	public String getAstImpl() {
		return getNode().toString();
	}

	@Override
	public AJoinPoint[] getChildrenArrayImpl() {
		return JackdawQueryEngine.getChildren(getNode());
	}

	@Override
	public AJoinPoint[] getDescendantsArrayImpl() {
		return JackdawQueryEngine.getDescendants(getNode());
	}

	@Override
	public Integer getLineImpl() {
		if (getNode().has("loc")) {
			return getNode().get("loc").getAsJsonObject().get("start").getAsJsonObject().get("line").getAsInt();
		} else
			return -1;
	}

	@Override
	public Integer getColumnImpl() {
		if (getNode().has("loc")) {
			return getNode().get("loc").getAsJsonObject().get("start").getAsJsonObject().get("column").getAsInt();
		} else
			return -1;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AJackdawWeaverJoinPoint)) {
			return false;
		}

		return getNode().equals(((AJackdawWeaverJoinPoint) obj).getNode());
	}

	@Override
	public int hashCode() {
		return getNode().hashCode();
	}

	@Override
	public String getUuidImpl() {
		return id.get();
	}
	@Override
	public String getCodeImpl() {
		String code = "";
		try {
			code = JackdawEngine.codeFromJSON(getNode());
		} catch (Exception e) {
			
		}
		return code;
	}

}
