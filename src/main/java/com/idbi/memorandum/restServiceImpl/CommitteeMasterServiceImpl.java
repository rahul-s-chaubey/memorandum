package com.idbi.memorandum.restServiceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbi.memorandum.dto.CommitteeDTO;
import com.idbi.memorandum.dto.ResponseDTO;
import com.idbi.memorandum.dto.SearchFilterDTO;
import com.idbi.memorandum.entities.CommitteeEntity;
import com.idbi.memorandum.repositories.CommitteeRepository;
import com.idbi.memorandum.restServices.CommitteeMasterService;

//@Service
//public class CommitteeMasterServiceImpl implements CommitteeMasterService
//{
//
//	@Override
//	public ResponseDTO createCommittee(CommitteeDTO committeeDTO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//}

@Service
public class CommitteeMasterServiceImpl implements CommitteeMasterService {

    @Autowired
    private CommitteeRepository committeeRepository;

    // CREATE
    @Override
    public ResponseDTO createCommittee(CommitteeDTO committeeDTO) {
    	
    	// NULL / EMPTY CHECK
        if (committeeDTO.getCommitteeName() == null ||
            committeeDTO.getCommitteeName().trim().isEmpty()) {

            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("FAILURE");
            responseDTO.setMessage("Committee name cannot be empty");
            responseDTO.setMemorandumNumber(null);
            return responseDTO;
        }
        
     // DUPLICATE CHECK
    	boolean exists = committeeRepository
    	        .existsByCommitteeName(committeeDTO.getCommitteeName());

    	if (exists) {
    	    ResponseDTO responseDTO = new ResponseDTO();
    	    responseDTO.setStatus("FAILURE");
    	    responseDTO.setMessage("Committee already exists");
    	    responseDTO.setMemorandumNumber(null);
    	    return responseDTO;
    	}
    	
    	// SAVE
        CommitteeEntity entity = new CommitteeEntity();
        entity.setCommitteeName(committeeDTO.getCommitteeName());
        entity.setCreatedBy(committeeDTO.getCreatedBy());
        entity.setCreatedOn(LocalDate.now());
        entity.setIsActive(true);


        CommitteeEntity savedEntity = committeeRepository.save(entity);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("200");
        responseDTO.setMessage("Committee created successfully");
        responseDTO.setMemorandumNumber(
                String.valueOf(savedEntity.getCommitteeId())
        );

        return responseDTO;
    }

    // UPDATE
    @Override
    public ResponseDTO updateCommittee(CommitteeDTO committeeDTO) {

        CommitteeEntity entity = committeeRepository
                .findById(committeeDTO.getCommitteeId())
                .orElseThrow(() -> new RuntimeException("Committee not found"));

        // Update name only if provided
        if (committeeDTO.getCommitteeName() != null &&
            !committeeDTO.getCommitteeName().trim().isEmpty()) {
            entity.setCommitteeName(committeeDTO.getCommitteeName().trim());
        }

        // Soft delete / activate
        if (committeeDTO.getIsActive() != null) {
            entity.setIsActive(committeeDTO.getIsActive());
        }

        entity.setUpdatedBy(committeeDTO.getUpdatedBy());
        entity.setUpdatedOn(LocalDate.now());

        committeeRepository.save(entity);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("SUCCESS");

        if (Boolean.FALSE.equals(committeeDTO.getIsActive())) {
            responseDTO.setMessage("Committee deleted successfully");
        } else {
            responseDTO.setMessage("Committee updated successfully");
        }

        responseDTO.setMemorandumNumber(
                String.valueOf(entity.getCommitteeId())
        );

        return responseDTO;
    }
    // LIST
    @Override
    public List<CommitteeDTO> getCommitteeList(SearchFilterDTO searchFilterDTO) {

        return committeeRepository.findByIsActiveTrue()

                .stream()
                .map(entity -> {
                    CommitteeDTO dto = new CommitteeDTO();
                    dto.setCommitteeId(entity.getCommitteeId());
                    dto.setCommitteeName(entity.getCommitteeName());
                    dto.setCreatedBy(entity.getCreatedBy());
                    return dto;
                })
                .toList();
    }

    // DETAIL
    @Override
    public CommitteeDTO getCommitteeById(SearchFilterDTO searchFilterDTO) {

        CommitteeEntity entity = committeeRepository
                .findById(searchFilterDTO.getCommitteeId())
                .orElseThrow(() -> new RuntimeException("Committee not found"));

        CommitteeDTO dto = new CommitteeDTO();
        dto.setCommitteeId(entity.getCommitteeId());
        dto.setCommitteeName(entity.getCommitteeName());
        dto.setCreatedBy(entity.getCreatedBy());

        return dto;
    }
}
