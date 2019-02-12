package pt.up.fe.specs.jsweaver.abstracts;

import pt.up.fe.specs.jsweaver.abstracts.joinpoints.AJoinPoint;

/**
 * Abstract class which can be edited by the developer. This class will not be
 * overwritten.
 * 
 * @author Lara Weaver Generator
 */
public abstract class AJsWeaverJoinPoint extends AJoinPoint {

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
		return null;
//		return getNode().getRoot();
	}

	@Override
	public String getTypeImpl() {
		return getNode().get("type").getAsString();
	}
}
