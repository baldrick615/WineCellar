package com.trm.winecellar.model;

public class RequestError {
	private Integer id;
	private String errorMessage;
	
	public RequestError(Integer id, String errorMessage) {
		this.id = id;
		this.errorMessage = errorMessage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
