package com.idbi.memorandum.dto;

import java.io.Serializable;

public class ResponseDTO  implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	String message;
	String memorandumNumber;
	String status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMemorandumNumber() {
		return memorandumNumber;
	}
	public void setMemorandumNumber(String memorandumNumber) {
		this.memorandumNumber = memorandumNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
