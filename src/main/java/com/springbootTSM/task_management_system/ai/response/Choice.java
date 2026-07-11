package com.springbootTSM.task_management_system.ai.response;

import com.springbootTSM.task_management_system.ai.request.Message;

public class Choice {

	private Message message;
	
	public void setMessage(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

}
