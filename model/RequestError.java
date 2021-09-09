package com.trm.winecellar.model;

public class RequestError {
	private Integer id;
	private String message;
	
	public RequestError(Integer id, String message) {
		this.setId(id);
		this.setMessage(message);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
