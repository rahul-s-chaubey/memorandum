package com.idbi.memorandum.restServiceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbi.memorandum.dto.MemorandumDTO;
import com.idbi.memorandum.dto.ResponseDTO;
import com.idbi.memorandum.dto.SearchFilterDTO;
import com.idbi.memorandum.dto.WorkflowDTO;
import com.idbi.memorandum.entities.MemorandumEntity;
import com.idbi.memorandum.repositories.MemorandumRepository;
import com.idbi.memorandum.restServices.MemorandumRestService;
import com.idbi.memorandum.restServices.ReferenceNumberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Service

public class MemorandumServiceImpl implements MemorandumRestService
{   
	
	@Autowired private MemorandumRepository memorandumRepository;
	
	
	@Autowired private ReferenceNumberService referenceNumberService;
	
	 @PersistenceContext
	 private EntityManager entityManager;
	
	@Override
	public ResponseDTO createMemorandum(MemorandumDTO memorandumDTO) 
	{
		MemorandumEntity entity = null;
		ResponseDTO responseDTO;
		//try 
		//{
			entity = new MemorandumEntity();
			entity.setCheckerEIN(memorandumDTO.getCheckerEIN());
			entity.setCommitteeName(memorandumDTO.getCommitteeName());
			
			entity.setCommonOutwardNumber(memorandumDTO.getCommonOutwardNumber());
			entity.setDateOfMeeting(memorandumDTO.getDateOfMeeting());
			entity.setDetails(memorandumDTO.getDetails());
			entity.setMemorandumDate(memorandumDTO.getMemorandumDate());
			entity.setMemorandumTo(memorandumDTO.getMemorandumTo());
			entity.setRemarks(memorandumDTO.getRemarks());
			entity.setCreatedOn(LocalDate.now());
			entity.setReceiptName(memorandumDTO.getReceiptName());
			entity.setStatus(memorandumDTO.getStatus()); //DRAFT, PENDING
			entity.setTitle(memorandumDTO.getTitle());
			entity.setMakerEIN(memorandumDTO.getMakerEIN());
			entity.setMakerName(memorandumDTO.getMakerName());
			entity.setCheckerEIN(memorandumDTO.getCheckerEIN());
			entity.setCheckerName(memorandumDTO.getCheckerName());
			entity.setIsActive(true);
			entity.setDepartmentId(memorandumDTO.getDepartmentId());
			entity.setDepartmentName(null);
			entity.setCommitteeId(memorandumDTO.getCommitteeId());
			//entity.setCommitteeName(null);
			
//			entity.setReferenceNo(referenceNumberService.generateReferenceNumber(memorandumDTO.getDepartmentId(), 
//																				memorandumDTO.getDepartmentName(), 
//																				memorandumDTO.getCommitteeId(), 
//																				memorandumDTO.getCommitteeName(), 
//																				memorandumDTO.getMemorandumDate()));
			
			entity.setReferenceNo(null);
			
			memorandumRepository.save(entity);
			responseDTO = new ResponseDTO ();
			responseDTO.setMemorandumNumber(entity.getReferenceNo());
			responseDTO.setMessage("Memorandum created");
			responseDTO.setStatus("200");
			
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//			
//			resonseDTO = new ResponseDTO ();
//			resonseDTO.setMemorandumNumber(entity.getReferenceNo());
//			resonseDTO.setMessage("Error occured while creating the memorandum");
//		}
		
		return responseDTO;
	}

	@Override
	public ResponseDTO updateStatus(WorkflowDTO workflowDTO) 
	{
		ResponseDTO responseDTO = null;
		MemorandumEntity entity = memorandumRepository.getMemorandumById(workflowDTO.getMemorandumId());
		if(workflowDTO.getStatus().equalsIgnoreCase("Approved"))
		{
			entity.setReferenceNo(referenceNumberService.generateReferenceNumber(entity.getDepartmentId(), 
					entity.getDepartmentName(), 
					entity.getCommitteeId(), 
					entity.getCommitteeName(), 
				    entity.getMemorandumDate()));
		}
		entity.setRejectionRemarks(workflowDTO.getRejectionRemarks());
		entity.setStatus(workflowDTO.getStatus());
		memorandumRepository.save(entity);
		responseDTO = new ResponseDTO ();
		responseDTO.setMemorandumNumber(entity.getReferenceNo());
		responseDTO.setMessage("Memorandum has been "+workflowDTO.getStatus());
		responseDTO.setStatus("200");
		responseDTO.setMemorandumNumber(entity.getReferenceNo());
		
		return responseDTO;
	}

	@Override
	public ResponseDTO updateMemorandum(MemorandumDTO memorandumDTO) 
	{
		ResponseDTO responseDTO = null;
		MemorandumEntity entity = memorandumRepository.getMemorandumById(memorandumDTO.getMemorandumId());
		BeanUtils.copyProperties(memorandumDTO, entity);
		memorandumRepository.save(entity);
		responseDTO = new ResponseDTO ();
		responseDTO.setMemorandumNumber(entity.getReferenceNo());
		responseDTO.setMessage("Memorandum has been Updated");
		responseDTO.setStatus("200");
		responseDTO.setMemorandumNumber(entity.getReferenceNo());
		
		return responseDTO;
	}

	@Override
	public MemorandumDTO getMemorandum(SearchFilterDTO serchFilterDTO) {

	    MemorandumEntity entity =
	            memorandumRepository.getMemorandumById(
	                    Long.valueOf(serchFilterDTO.getId()));

	    if (entity == null) {
	        throw new RuntimeException("Memorandum not found");
	    }

	    MemorandumDTO dto = new MemorandumDTO();
	    BeanUtils.copyProperties(entity, dto);

	    return dto;
	}

	
	@Override
	public List<MemorandumDTO> getMemorandumList(SearchFilterDTO dto) {

	    String jpql = "FROM MemorandumEntity e WHERE e.isActive = true";

	    if (dto.getMemorandumTo() != null)
	        jpql += " AND e.memorandumTo = :memorandumTo";

	    if (dto.getCommitteeName() != null)
	        jpql += " AND e.committeeName = :committeeName";

	    if (dto.getCheckerEin() != null)
	        jpql += " AND e.checkerEIN = :checkerEin";

	    if (dto.getStatus() != null)
	        jpql += " AND e.status = :status";

	    if (dto.getTitle() != null)
	        jpql += " AND LOWER(e.title) LIKE :title";

	    if (dto.getReferenceNo() != null)
	        jpql += " AND e.referenceNo LIKE :referenceNo";

	    TypedQuery<MemorandumEntity> query =
	            entityManager.createQuery(jpql, MemorandumEntity.class);

	    if (dto.getMemorandumTo() != null)
	        query.setParameter("memorandumTo", dto.getMemorandumTo());

	    if (dto.getCommitteeName() != null)
	        query.setParameter("committeeName", dto.getCommitteeName());

	    if (dto.getCheckerEin() != null)
	        query.setParameter("checkerEin", dto.getCheckerEin());

	    if (dto.getStatus() != null)
	        query.setParameter("status", dto.getStatus());

	    if (dto.getTitle() != null)
	        query.setParameter("title", "%" + dto.getTitle().toLowerCase() + "%");

	    if (dto.getReferenceNo() != null)
	        query.setParameter("referenceNo", "%" + dto.getReferenceNo() + "%");

	    return query.getResultList()
	            .stream()
	            .map(entity -> {
	                MemorandumDTO m = new MemorandumDTO();
	                BeanUtils.copyProperties(entity, m);
	                return m;
	            })
	            .toList();
	}



}
