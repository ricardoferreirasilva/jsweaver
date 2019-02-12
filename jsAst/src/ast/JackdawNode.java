package ast;

import java.util.Arrays;
import java.util.Collection;

import org.suikasoft.jOptions.Datakey.DataKey;
import org.suikasoft.jOptions.Datakey.KeyFactory;
import org.suikasoft.jOptions.Interfaces.DataStore;

import pt.up.fe.specs.util.treenode.ATreeNode;

public abstract class JackdawNode extends ATreeNode<JackdawNode> {

	public final static DataKey<String> TYPE = KeyFactory.string("type");
	
	public JackdawNode(DataStore data, Collection<? extends JackdawNode> children) {
		super(children);
	}
//	@Override
//	public String toContentString() {
//		return getData().toInlinedString();
//	}
	@Override
	protected JackdawNode getThis() {
		return this;
	}
	@Override
	protected JackdawNode copyPrivate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toContentString() {
		// TODO Auto-generated method stub
		return null;
	}
}
