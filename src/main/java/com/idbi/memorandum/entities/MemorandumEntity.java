package com.idbi.memorandum.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name ="MEMORANDUM_MST")
@Entity
public class MemorandumEntity 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="memorandum_id")
	private Long memorandumId;
	
	@Column(name ="memorandum_to")
	private String memorandumTo;
	
	@Column(name ="memorandum_title")
	private String title;
	
	@Column(name ="receipt_name")
	private String receiptName;
	
	@Column(name ="memorandum_date")
	private LocalDate memorandumDate;
	
	@Column(name ="meeting_date")
	private LocalDate dateOfMeeting;
	
	@Column(name ="committee_name")
	private String committeeName;
	
	@Column(name ="checker_ein")
	private String checkerEIN;
	
	@Column(name ="checker_name")
	private String checkerName;
	
	@Column(name ="reference_no")
	private String referenceNo;
	
	@Column(name ="common_outward_number")
	private String commonOutwardNumber;
	
	@Column(name ="details")
	private String details;
	
	@Column(name ="remarks")
	private String remarks;
	
	@Column(name ="maker_ein")
	private String makerEIN;
	
	@Column(name ="maker_name")
	private String makerName;
	
	@Column(name ="status")
	private String status;

	@Column(name ="updated_date")
	private LocalDate updatedOn;
	
	@Column(name ="created_date")
	private LocalDate createdOn;
	
	@Column(name ="committee_id")
	private Long committeeId;
	
	@Column(name ="department_name")
	private String departmentName;
	
	@Column(name ="department_id")
	private Long departmentId;
	
	@Column(name ="rejection_remark")
	private String rejectionRemarks;
	
	@Column(name ="is_Active")
	private Boolean isActive;
	
	
	public String getMemorandumTo() {
		return memorandumTo;
	}

	public void setMemorandumTo(String memorandumTo) {
		this.memorandumTo = memorandumTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getMemorandumDate() {
		return memorandumDate;
	}

	public void setMemorandumDate(LocalDate memorandumDate) {
		this.memorandumDate = memorandumDate;
	}

	public LocalDate getDateOfMeeting() {
		return dateOfMeeting;
	}

	public void setDateOfMeeting(LocalDate dateOfMeeting) {
		this.dateOfMeeting = dateOfMeeting;
	}


	public String getCheckerEIN() {
		return checkerEIN;
	}

	public void setCheckerEIN(String checkerEIN) {
		this.checkerEIN = checkerEIN;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getCommonOutwardNumber() {
		return commonOutwardNumber;
	}

	public void setCommonOutwardNumber(String commonOutwardNumber) {
		this.commonOutwardNumber = commonOutwardNumber;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getMemorandumId() {
		return memorandumId;
	}

	public void setMemorandumId( Long memorandumId) {
		this.memorandumId = memorandumId;
	}


	public String getReceiptName() {
		return receiptName;
	}

	public void setReceiptName(String receiptName) {
		this.receiptName = receiptName;
	}

	public String getCheckerName() {
		return checkerName;
	}

	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public Long getCommitteeId() {
		return committeeId;
	}

	public void setCommitteeId(Long committeeId) {
		this.committeeId = committeeId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getCommitteeName() {
		return committeeName;
	}

	public void setCommitteeName(String committeeName) {
		this.committeeName = committeeName;
	}

	public String getMakerEIN() {
		return makerEIN;
	}

	public void setMakerEIN(String makerEIN) {
		this.makerEIN = makerEIN;
	}

	public String getMakerName() {
		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public String getRejectionRemarks() {
		return rejectionRemarks;
	}

	public void setRejectionRemarks(String rejectionRemarks) {
		this.rejectionRemarks = rejectionRemarks;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
}
