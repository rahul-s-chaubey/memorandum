package com.idbi.memorandum.repositories;

import com.idbi.memorandum.entities.MemoSequenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import jakarta.persistence.LockModeType;
import java.util.Optional;

public interface MemoSequenceRepository extends JpaRepository<MemoSequenceEntity, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<MemoSequenceEntity> findByDepartmentIdAndCommitteeIdAndFinancialYear(
            Long departmentId,
            Long committeeId,
            String financialYear
    );
}