package com.idbi.memorandum.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idbi.memorandum.entities.CommitteeEntity;

@Repository
public interface CommitteeRepository  extends JpaRepository<CommitteeEntity, Long>{
	boolean existsByCommitteeName(String committeeName);
	List<CommitteeEntity> findByIsActiveTrue();


}
