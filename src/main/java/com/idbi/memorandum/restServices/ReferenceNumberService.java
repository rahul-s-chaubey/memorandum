package com.idbi.memorandum.restServices;

import java.time.LocalDate;

public interface ReferenceNumberService 
{
	   public String generateReferenceNumber(
	            Long departmentId,
	            String departmentName,
	            Long committeeId,
	            String committeeName,
	            LocalDate memorandumDate
	    );
}
