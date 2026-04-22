package com.idbi.memorandum.restServiceImpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idbi.memorandum.entities.MemoSequenceEntity;
import com.idbi.memorandum.repositories.MemoSequenceRepository;
import com.idbi.memorandum.restServices.ReferenceNumberService;

@Service
public class ReferenceNumberServiceImpl implements ReferenceNumberService {

    @Autowired
    private MemoSequenceRepository sequenceRepository;

    @Override
    @Transactional
    public String generateReferenceNumber(
            String documentType,
            Long departmentId,
            String departmentName,
            Long committeeId,
            String committeeName,
            LocalDate documentDate) {

        String financialYear = computeFinancialYear(documentDate);

        // Normalize blank to null
        Long effectiveDepartmentId = departmentId;
        Long effectiveCommitteeId = committeeId;

        MemoSequenceEntity sequence = sequenceRepository
                .findByDepartmentIdAndCommitteeIdAndDocumentTypeAndFinancialYear(
                        effectiveDepartmentId,
                        effectiveCommitteeId,
                        documentType,
                        financialYear)
                .orElseGet(() -> {
                    MemoSequenceEntity newSeq = new MemoSequenceEntity();
                    newSeq.setDepartmentId(effectiveDepartmentId);
                    newSeq.setCommitteeId(effectiveCommitteeId);
                    newSeq.setDocumentType(documentType);
                    newSeq.setFinancialYear(financialYear);
                    newSeq.setLastNumber(0);
                    return newSeq;
                });

        int nextNumber = sequence.getLastNumber() + 1;
        sequence.setLastNumber(nextNumber);
        sequenceRepository.save(sequence);

        String formattedNumber = String.format("%02d", nextNumber);

        return buildReferenceNumber(
                documentType,
                departmentName,
                committeeName,
                formattedNumber,
                financialYear);
    }

    private String buildReferenceNumber(
            String documentType,
            String departmentName,
            String committeeName,
            String formattedNumber,
            String financialYear) {

        if ("MEMORANDUM".equalsIgnoreCase(documentType)) {
            return "IDBI Bank / "
                    + safe(departmentName) + " / "
                    + safe(committeeName) + " / "
                    + formattedNumber + " / "
                    + financialYear;
        }

        if ("OFFICE_NOTE".equalsIgnoreCase(documentType)) {
            return "IDBI Bank / OFFICE NOTE / "
                    + formattedNumber + " / "
                    + financialYear;
        }

        if ("OFFICIAL_LETTER".equalsIgnoreCase(documentType)) {
            return "IDBI Bank / OFFICIAL LETTER / "
                    + formattedNumber + " / "
                    + financialYear;
        }

        throw new RuntimeException("Invalid Document Type");
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }

    private String computeFinancialYear(LocalDate date) {
        if (date == null) {
            date = LocalDate.now();
        }

        int year = date.getYear();
        int month = date.getMonthValue();

        if (month >= 4) {
            int next = (year + 1) % 100;
            return year + "-" + String.format("%02d", next);
        } else {
            int prev = year - 1;
            int curShort = year % 100;
            return prev + "-" + String.format("%02d", curShort);
        }
    }
}