package com.idbi.memorandum.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idbi.memorandum.entities.EmpEntity;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, String> {

    Optional<EmpEntity> findByEmail(String email);
}

