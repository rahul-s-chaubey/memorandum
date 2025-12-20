package com.idbi.memorandum.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="COMMITTEE_MST")
public class CommitteeEntity 
{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "committee_id" )
	private Long committeeId;
	@Column(name = "committee_name" )
	private String committeeName;
	@Column(name = "created_by" )
	private String createdBy; //ein
	@Column(name = "created_at" )
	private LocalDate createdOn;
	@Column(name = "updated_by" )
	private String updatedBy;
	@Column(name = "updated_at" )
	private LocalDate updatedOn;
	@Column(name = "is_active")
	private Boolean isActive;
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

	
}
