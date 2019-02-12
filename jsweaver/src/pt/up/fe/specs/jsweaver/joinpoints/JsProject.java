package pt.up.fe.specs.jsweaver.joinpoints;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jsweaver.abstracts.joinpoints.AFile;
import pt.up.fe.specs.jsweaver.abstracts.joinpoints.AJoinPoint;
import pt.up.fe.specs.jsweaver.abstracts.joinpoints.AProject;

public class JsProject extends AProject {

	private final JsonObject project;

	public JsProject(JsonObject project) {
		this.project = project;
		// TODO Auto-generated constructor stub
	}

	@Override
	public AJoinPoint[] getFunctionsArrayImpl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends AFile> selectFile() {
		JsonArray files = project.get("files").getAsJsonArray();

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject getNode() {
		return project;
	}

}
