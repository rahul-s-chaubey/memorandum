package com.idbi.memorandum.restServices;

import java.time.LocalDate;

public interface ReferenceNumberService {

    String generateReferenceNumber(
            String documentType,
            Long departmentId,
            String departmentName,
            Long committeeId,
            String committeeName,
            LocalDate documentDate
    );
}