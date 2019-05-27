package pt.up.fe.specs.jackdaw.joinpoints;

import java.io.File;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AFile;

public class JsFile extends AFile {

	private final JsonObject node;

	public JsFile(JsonObject file) {
		this.node = file;
	}

	@Override
	public JsonObject getNode() {
		return this.node;
	}

	@Override
	public String getPathImpl() {
		String path = node.get("path").getAsString();
		return path;
	}

	@Override
	public String getNameImpl() {
		String path = node.get("path").getAsString();
		File f = new File(path);
		return f.getName();
	}
}
