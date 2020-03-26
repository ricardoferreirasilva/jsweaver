package pt.up.fe.specs.jackdaw.joinpoints.expressions;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.ParentMapper;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AIdentifier;

public class JsIdentifier extends AIdentifier {

    private final JsonObject node;

    public JsIdentifier(JsonObject node) {
        this.node = node;
    }

    @Override
    public String getNameImpl() {
        return this.node.get("name").getAsString();
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

    @Override
    public void setNameImpl(String name) {
        defNameImpl(name);
    }

    @Override
    public void defNameImpl(String name) {
        String oldName = this.node.get("name").getAsString();
        this.node.addProperty("name", name);
        // JackdawUtilities.reformParents(JackdawWeaver.getJackdawWeaver().select().getNode());
        ParentMapper.setDirty();
        System.out.println(oldName + " -->" + name);
    }

}
