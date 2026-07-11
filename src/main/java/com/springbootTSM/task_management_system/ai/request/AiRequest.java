package com.springbootTSM.task_management_system.ai.request;

import java.util.List;

public class AiRequest {

	private String model;
	
	private List<Message> messaage;
	
	
	public void setModel(String model) {
		this.model = model;
	}

	public void setMessaage(List<Message> messaage) {
		this.messaage = messaage;
	}

	public String getModel() {
		return model;
	}

	public List<Message> getMessaage() {
		return messaage;
	}
	
	
}
