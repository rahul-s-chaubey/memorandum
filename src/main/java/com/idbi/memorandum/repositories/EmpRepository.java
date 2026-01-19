package com.idbi.memorandum.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.idbi.memorandum.entities.EmpEntity;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, String> {

    Optional<EmpEntity> findByEmail(String email);
    
    @Query("SELECT e FROM EmpEntity e WHERE e.grade >= 'C'")
    List<EmpEntity> findCheckersGradeCAndAbove();
}

