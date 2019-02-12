package pt.up.fe.specs.jsweaver.joinpoints;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jsweaver.abstracts.joinpoints.AFile;

public class JsFile extends AFile {

	private final JsonObject fileJSON;

	public JsFile(JsonObject file) {
		this.fileJSON = file;
	}

	@Override
	public JsonObject getNode() {
		return fileJSON;
	}

	@Override
	public String getPathImpl() {
		// TODO Auto-generated method stub
		return null;
	}

}
