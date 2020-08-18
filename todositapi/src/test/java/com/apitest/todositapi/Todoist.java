package com.apitest.todositapi;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Todoist {
	
	 RequestSpecification httpRequest;
	
	
	public Todoist() {
		
		  RestAssured.baseURI = "https://api.todoist.com/rest/v1";
		  
		  httpRequest = RestAssured.given();
		  
		  String token = "f11af7ba96d894a21f178dc9b293163058290b1c";
		  
		  httpRequest.header("Content-type","application/json");
		  httpRequest.header("Authorization", String.format("Bearer %s", token));

	}
	
	public String getAllProjects() {
		
		Response response = httpRequest.request(Method.GET,"/projects");
		String responseBody = response.getBody().asString();
		
	
		return responseBody;
		
	}

	public String getProjectByID(String projectId) {
		
		Response response = httpRequest.request(Method.GET,"/projects/"+projectId);
		String responseBody = response.getBody().asString();
		
		return responseBody;
		
	}

	public String createNewProject(String projectName) {
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", projectName);
		
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.POST,"/projects");
		String responseBody = response.getBody().asString();
		
		
		return responseBody;
		
	}
	
	public String createTaskInProject(Long projectId, String content) {
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("content", content);
		requestParams.put("project_id", projectId);
		requestParams.put("due_string", "tomorrow at 12:00");
		requestParams.put("due_lang", "eng");
		requestParams.put("priority", 4);
		
		
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.POST,"/tasks");
		String responseBody = response.getBody().asString();
		
		
		return responseBody;
		
		
	}
	
	public String getAllActiveTask() {
		
	
		
		Response response = httpRequest.request(Method.GET,"/tasks");
		String responseBody = response.getBody().asString();
		
		return responseBody;
		
	}
	public String getTasksByProject(long projectId) {
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("project_id", projectId);
		
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.GET,"/tasks");
		String responseBody = response.getBody().asString();
		
		return responseBody;
	}

	public String getTaskDetails(long taskId) {
		
		Response response = httpRequest.request(Method.GET,"/tasks/"+taskId);
		String responseBody = response.getBody().asString();
		
		return responseBody;
	}
	
	public String closeTask(long taskId) {
		
		Response response = httpRequest.request(Method.POST,"/tasks/"+taskId+"/close");
		String responseBody = response.getBody().asString();
		return responseBody;
		
	}
	
	public String repoenTask(long taskId) {
		
		Response response = httpRequest.request(Method.POST,"/tasks/"+taskId+"/reopen");
		String responseBody = response.getBody().asString();
		return responseBody;
		
	}
	

}
