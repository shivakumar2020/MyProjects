package com.apitest.todositapi;

import org.testng.annotations.Test;

public class TestTodoist {
	
	 Todoist td=new Todoist();

	// @Test
	  public void getAllProject() {
		  
		 String projects = td.getAllProjects();
		 System.out.println(projects);
		 
		  
	  }
	  
//	  @Test
	  public void getProjectByID() {
		  
		 String projects = td.getProjectByID("2241926375");
		 System.out.println(projects);
		 
		  
	  }

	  //@Test
	  public void createNewProject() {
		  
		 String projects = td.createNewProject("New Project from API");
		 System.out.println(projects);
		  
		  
	  }
	  

	//  @Test
	  public void createNewTaskInProject() {
		  
		 String projects = td.createTaskInProject(2241926375L, "Test Project Task 1");
		 
		 System.out.println(projects);
		 
		  
	  }
	//   @Test
	  public void getAllActiveTasks() {
		  
			 String tasks = td.getAllActiveTask();
			 System.out.println(tasks);
			 
			  
		  }
	//  @Test
	  public void getTasksDetails() {
		  
		  
		  	String task = td.getTaskDetails(4106232338L);
	  	
			 System.out.println(task);
	  }
	//  @Test
	  public void closeTask() {
		  
		  
		  long taskId = 4106251884L;
		  	String task = td.closeTask(taskId);
		  	
		  	System.out.println(task);
		  	System.out.println(td.getTaskDetails(taskId));
	  }
	 
	  @Test
	  public void reopenTask() {
		  
		  
		  long taskId = 4106251884L;
		  	String task = td.repoenTask(taskId);
		  	
		  	System.out.println(task);
		  	System.out.println(td.getTaskDetails(taskId));
		  	
		  	
	  }

	
	  
}
