package com.idbi.memorandum.dto;

import java.time.LocalDate;

public class CommitteeDTO 
{
	private Long committeeId;
	private String committeeName;
	private String createdBy; //ein
	private LocalDate createdOn;
	private String updatedBy;
	private LocalDate updatedOn;
	private Boolean isActive;
	private String committeeCode;
	private String description;

	public Long getCommitteeId() {
		return committeeId;
	}
	public void setCommitteeId(Long committeeId) {
		this.committeeId = committeeId;
	}
	public String getCommitteeName() {
		return committeeName;
	}
	public void setCommitteeName(String committeeName) {
		this.committeeName = committeeName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDate getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}
	public Boolean getIsActive() {
	    return isActive;
	}

	public void setIsActive(Boolean isActive) {
	    this.isActive = isActive;
	}

	public String getCommitteeCode() {
	    return committeeCode;
	}
	public void setCommitteeCode(String committeeCode) {
	    this.committeeCode = committeeCode;
	}

	public String getDescription() {
	    return description;
	}
	public void setDescription(String description) {
	    this.description = description;
	}

	
}
