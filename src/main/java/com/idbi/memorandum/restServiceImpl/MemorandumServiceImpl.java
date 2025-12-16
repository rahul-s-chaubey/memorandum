package com.idbi.memorandum.restServiceImpl;

import java.time.LocalDate;

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

@Service
public class MemorandumServiceImpl implements MemorandumRestService
{
	@Autowired private MemorandumRepository memorandumRepository;
	
	@Autowired private ReferenceNumberService referenceNumberService;
	
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
			entity.setCommitteeName(null);
			
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
		if(entity.getStatus().equalsIgnoreCase("Pending") || entity.getStatus().equalsIgnoreCase("Saved as Draft"))
		{
			BeanUtils.copyProperties(memorandumDTO, entity);
			memorandumRepository.save(entity);
		}
		memorandumRepository.save(entity);
		responseDTO = new ResponseDTO ();
		responseDTO.setMemorandumNumber(entity.getReferenceNo());
		responseDTO.setMessage("Memorandum has been Updated");
		responseDTO.setStatus("200");
		responseDTO.setMemorandumNumber(entity.getReferenceNo());
		
		return responseDTO;
	}

	@Override
	public MemorandumDTO getMemorandum(SearchFilterDTO serchFilterDTO) 
	{
		
		
			return null;
	}

}
