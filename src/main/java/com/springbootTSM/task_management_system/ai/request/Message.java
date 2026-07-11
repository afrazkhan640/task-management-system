package com.springbootTSM.task_management_system.ai.request;

public class Message {

	private String role;
	private String content;
	
	public Message(String role, String content) {
		this.role = role;
		this.content = content;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRole() {
		return role;
	}

	public String getContent() {
		return content;
	}
	
	
	
	
}
