package com.idbi.memorandum.dto;

import java.io.Serializable;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;



public class MemorandumDTO implements Serializable
{

	 
	private static final long serialVersionUID = 1L;
	private String documentType;
	
	private Long memorandumId;
	
	private String memorandumTo;
	
	private String title;
	
	private String receiptName;
	
	private LocalDate memorandumDate;
	
	private LocalDate dateOfMeeting;
	
	private String committeeName;
	
	@JsonProperty("checkerEin")
	private String checkerEIN;
	
	private String checkerName;
	
	private String referenceNo;
	
	private String commonOutwardNumber;
	
	private String details;
	
	private String remarks;
	
	@JsonProperty("makerEIN")
	private String makerEIN;
	
	private String makerName;
	
	private String status;

	private LocalDate updatedOn;
	
	private LocalDate createdOn;
	
	private Long committeeId;
	
	private String departmentName;
	
	private Long departmentId;
	
	private String rejectionRemarks;
	
	private LocalDate dateOfDocument;
	
	private String letterSentTo;
	
	
	public String getDocumentType() {
	    return documentType;
	}

	public void setDocumentType(String documentType) {
	    this.documentType = documentType;
	}

	public Long getMemorandumId() {
		return memorandumId;
	}

	public void setMemorandumId(Long memorandumId) {
		this.memorandumId = memorandumId;
	}

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

	public String getReceiptName() {
		return receiptName;
	}

	public void setReceiptName(String receiptName) {
		this.receiptName = receiptName;
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

	public String getCommitteeName() {
		return committeeName;
	}

	public void setCommitteeName(String committeeName) {
		this.committeeName = committeeName;
	}

	public String getCheckerEIN() {
		return checkerEIN;
	}

	public void setCheckerEIN(String checkerEIN) {
		this.checkerEIN = checkerEIN;
	}

	public String getCheckerName() {
		return checkerName;
	}

	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRejectionRemarks() {
		return rejectionRemarks;
	}

	public void setRejectionRemarks(String rejectionRemarks) {
		this.rejectionRemarks = rejectionRemarks;
	}

	public LocalDate getDateOfDocument() {
		return dateOfDocument;
	}

	public void setDateOfDocument(LocalDate dateOfDocument) {
		this.dateOfDocument = dateOfDocument;
	}

	public String getLetterSentTo() {
		return letterSentTo;
	}

	public void setLetterSentTo(String letterSentTo) {
		this.letterSentTo = letterSentTo;
	}
	
	
	

}
