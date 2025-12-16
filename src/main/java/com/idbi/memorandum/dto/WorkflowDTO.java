package com.idbi.memorandum.dto;

import java.io.Serializable;

public class WorkflowDTO implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	Long memorandumId;
	String status;
	String rejectionRemarks;
	public Long getMemorandumId() {
		return memorandumId;
	}
	public void setMemorandumId(Long memorandumId) {
		this.memorandumId = memorandumId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRejectionRemarks() {
		return rejectionRemarks;
	}
	public void setRejectionRemarks(String rejectionRemarks) {
		this.rejectionRemarks = rejectionRemarks;
	}
	
	
	
}
