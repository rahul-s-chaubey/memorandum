package com.idbi.memorandum.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "memo_emp_master", schema = "memorandum")
public class EmpEntity {

    @Id
    @Column(name = "ein")
    private String ein;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "full_name_title")
    private String fullNameTitle;

    // 🔹 NEW FIELDS (ADDED)

    @Column(name = "grade")
    private String grade;

    @Column(name = "sol")
    private String sol;

    @Column(name = "organization")
    private String organization;

    @Column(name = "sup_ein")
    private String supEin;

    @Column(name = "sup_full_name_title")
    private String supFullNameTitle;

    @Column(name = "sup_email")
    private String supEmail;

    // ===== GETTERS =====

    public String getEin() {
        return ein;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getFullNameTitle() {
        return fullNameTitle;
    }

    public String getGrade() {
        return grade;
    }

    public String getSol() {
        return sol;
    }

    public String getOrganization() {
        return organization;
    }

    public String getSupEin() {
        return supEin;
    }

    public String getSupFullNameTitle() {
        return supFullNameTitle;
    }

    public String getSupEmail() {
        return supEmail;
    }

    // ===== SETTERS =====

    public void setEin(String ein) {
        this.ein = ein;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setFullNameTitle(String fullNameTitle) {
        this.fullNameTitle = fullNameTitle;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSol(String sol) {
        this.sol = sol;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setSupEin(String supEin) {
        this.supEin = supEin;
    }

    public void setSupFullNameTitle(String supFullNameTitle) {
        this.supFullNameTitle = supFullNameTitle;
    }

    public void setSupEmail(String supEmail) {
        this.supEmail = supEmail;
    }
}
