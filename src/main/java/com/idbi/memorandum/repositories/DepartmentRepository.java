package com.idbi.memorandum.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idbi.memorandum.entities.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    boolean existsByDepartmentName(String departmentName);

    List<DepartmentEntity> findByIsActiveTrue();
}
