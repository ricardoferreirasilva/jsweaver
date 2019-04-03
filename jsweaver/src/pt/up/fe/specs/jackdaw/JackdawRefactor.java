package pt.up.fe.specs.jackdaw;


import java.util.Map.Entry;

import javax.management.RuntimeErrorException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.abstracts.AJackdawWeaverJoinPoint;

public class JackdawRefactor {
	public static void refactorJoinpoint(AJackdawWeaverJoinPoint jp,String newName) {
		JsonObject node = jp.getNode();
		JsonObject root = ParentMapper.getRoot(node);
		switch (jp.getJoinPointType()) {
		case "declarator":
			JsonObject identifier = node.get("id").getAsJsonObject();
			String oldName = identifier.get("name").getAsString();
			identifier.addProperty("name", newName);
			JackdawUtilities.reformParents(root);
			propagateRefactoring(node,oldName,newName);
			break;
		case "functionDeclaration":
			JsonObject functionIdentifier = node.get("id").getAsJsonObject();
			String functionName = functionIdentifier.get("name").getAsString();
			functionIdentifier.addProperty("name", newName);
			JackdawUtilities.reformParents(root);
			propagateRefactoring(node,functionName,newName);
			
			
			break;

		default:
			throw new RuntimeErrorException(null, "Cannot refactor this type of joinpoint.");
		}
		
	}
	private static void propagateRefactoring(JsonObject node,String oldName,String newName) {
		   Boolean zoneFound = false;
		   //When we also have to propate inside and not just bellow ex: function declaration.
		   if (JackdawUtilities.nodeIsInsertable(node)) {
	            propagateNewName(node, oldName, newName);

	            
	        }
			//Finding insertable parent to propagate bellow.
	        while (!zoneFound) {
	           JsonObject anchor = node;
	           node = ParentMapper.getParent(node);
	           if (JackdawUtilities.nodeIsInsertable(node)) {
	               zoneFound = true;
	               propagateBellowAnchor(node,anchor, oldName,  newName);
	               break;
	           }
	       }
	}
	private static void propagateBellowAnchor(JsonObject node,JsonObject anchor,String oldName,String newName)
	{
		 JsonArray elements = node.get("body").getAsJsonArray();
		 Boolean propagating = false;
		 for (JsonElement elem : elements) {
			 if(propagating == true) {
				 propagateNewName(elem.getAsJsonObject(),oldName,newName);

			 }
			 if(elem.getAsJsonObject().equals(anchor)) {
				 propagating = true;
			 }
		 }
		
		
	}
	private static void propagateNewName(JsonObject node,String oldName,String newName) {
		if(node.has("type")) {
			String type = node.get("type").getAsString();
			if(type.equals("Identifier")) {
				
				String name = node.get("name").getAsString();
				
				if(name.equals(oldName)) {
					node.addProperty("name", newName);
					AJackdawWeaverJoinPoint rootJoinPoint = (AJackdawWeaverJoinPoint) JackdawWeaver.getJackdawWeaver().select();
					JsonObject root = rootJoinPoint.getNode();
					JackdawUtilities.reformParents(root);
				}
			}
		}
		 for (Entry<String, JsonElement> key : node.entrySet()) {
            JsonElement child = key.getValue();
            if(child.isJsonObject()) propagateNewName(child.getAsJsonObject(),oldName,newName);
            else if(child.isJsonArray()) {
            	for (JsonElement stm : child.getAsJsonArray()) {
            		  propagateNewName(stm.getAsJsonObject(),oldName,newName);
				}
            	
            }
        }
		
	}
	
	
}
