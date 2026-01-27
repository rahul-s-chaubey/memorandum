package com.idbi.memorandum.restServiceImpl;


import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.idbi.memorandum.entities.MemoSequenceEntity;
import com.idbi.memorandum.repositories.MemoSequenceRepository;
import com.idbi.memorandum.restServices.ReferenceNumberService;

@Service
public class ReferenceNumberServiceImpl  implements ReferenceNumberService{

    @Autowired private   MemoSequenceRepository sequenceRepository = null;


    @Override
    @Transactional
    public String generateReferenceNumber(
            Long departmentId,
            String departmentName,
            Long committeeId,
            String committeeName,
            LocalDate memorandumDate
    ) {

        // 1) FY calculate
        String financialYear = computeFinancialYear(memorandumDate);

        // 2) Existing sequence row lock + fetch
        MemoSequenceEntity seq = sequenceRepository
                .findByDepartmentIdAndCommitteeIdAndFinancialYear(
                        departmentId, committeeId, financialYear
                )
                .orElseGet(() -> {
                    MemoSequenceEntity e = new MemoSequenceEntity();
                    e.setDepartmentId(departmentId);
                    e.setCommitteeId(committeeId);
                    e.setFinancialYear(financialYear);
                    e.setLastNumber(0);     // abhi tak koi memo nahi
                    return e;
                });

        // 3) Next number
        int nextNumber = seq.getLastNumber() + 1;
        seq.setLastNumber(nextNumber);
        sequenceRepository.save(seq);       // same transaction

        // 4) 2-digit formatting (01, 02, 03...)
        String memoNumberFormatted = String.format("%02d", nextNumber);

        // 5) Final reference number
        return "IDBI Bank / "
                + departmentName
                + " / "
                + committeeName
                + " / "
                + memoNumberFormatted
                + " / "
                + financialYear;
    }

    private String computeFinancialYear(LocalDate date) {
        if (date == null) {
            date = LocalDate.now();
        }
        int year = date.getYear();
        int month = date.getMonthValue(); // 1..12

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