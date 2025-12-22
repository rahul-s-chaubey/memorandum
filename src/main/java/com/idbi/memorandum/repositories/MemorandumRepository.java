package com.idbi.memorandum.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idbi.memorandum.entities.MemorandumEntity;

@Repository
public interface MemorandumRepository  extends JpaRepository<MemorandumEntity, Integer>
{
	@Query("FROM MemorandumEntity e where e.memorandumId=:memorandumId")
	MemorandumEntity getMemorandumById(@Param("memorandumId")Long memorandumId);
	
	 List<MemorandumEntity> findByIsActiveTrue();
}
