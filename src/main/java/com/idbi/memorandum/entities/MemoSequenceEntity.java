package com.idbi.memorandum.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "MEMO_SEQUENCE",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "UK_MEMO_SEQ_COMBINATION",
            columnNames = {"department_id", "committee_id", "document_type", "financial_year"}
        )
    }
)
public class MemoSequenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ NOW NULLABLE
    @Column(name = "department_id", nullable = true)
    private Long departmentId;

    // ✅ NOW NULLABLE
    @Column(name = "committee_id", nullable = true)
    private Long committeeId;

    @Column(name = "document_type", nullable = false, length = 30)
    private String documentType;

    @Column(name = "financial_year", nullable = false, length = 9)
    private String financialYear;

    @Column(name = "last_number", nullable = false)
    private Integer lastNumber;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }

    public Long getCommitteeId() { return committeeId; }
    public void setCommitteeId(Long committeeId) { this.committeeId = committeeId; }

    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public String getFinancialYear() { return financialYear; }
    public void setFinancialYear(String financialYear) { this.financialYear = financialYear; }

    public Integer getLastNumber() { return lastNumber; }
    public void setLastNumber(Integer lastNumber) { this.lastNumber = lastNumber; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}