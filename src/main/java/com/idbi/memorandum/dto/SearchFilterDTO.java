package com.idbi.memorandum.dto;

import java.io.Serializable;

public class SearchFilterDTO implements Serializable
{

	private static final long serialVersionUID = 1L;
	private Integer id;  //this could be memorandumId, departmentId or committeeId
	
	private String memorandumTo;
	
	private String committeeName;
	
	private String checkerEin;
	
	private String makerEin;
	
	private String status;
	
	private String title;
	
	private String referenceNo;
	
	private String dateOfMemorandum;
	
	private String departmentName;
	
	private Long committeeId;
	
	private Long departmentId;
	
	private Long solId;
	
	private String committeeType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMemorandumTo() {
		return memorandumTo;
	}

	public void setMemorandumTo(String memorandumTo) {
		this.memorandumTo = memorandumTo;
	}

	public String getCommitteeName() {
		return committeeName;
	}

	public void setCommitteeName(String committeeName) {
		this.committeeName = committeeName;
	}

	public String getCheckerEin() {
		return checkerEin;
	}

	public void setCheckerEin(String checkerEin) {
		this.checkerEin = checkerEin;
	}

	public String getMakerEin() {
		return makerEin;
	}

	public void setMakerEin(String makerEin) {
		this.makerEin = makerEin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getDateOfMemorandum() {
		return dateOfMemorandum;
	}

	public void setDateOfMemorandum(String dateOfMemorandum) {
		this.dateOfMemorandum = dateOfMemorandum;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getCommitteeId() {
		return committeeId;
	}

	public void setCommitteeId(Long committeeId) {
		this.committeeId = committeeId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getSolId() {
		return solId;
	}

	public void setSolId(Long solId) {
		this.solId = solId;
	}

	public String getCommitteeType() {
		return committeeType;
	}

	public void setCommitteeType(String committeeType) {
		this.committeeType = committeeType;
	}

	
	
}
