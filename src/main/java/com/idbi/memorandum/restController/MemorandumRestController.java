package com.idbi.memorandum.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbi.memorandum.dto.MemorandumDTO;
import com.idbi.memorandum.dto.ResponseDTO;
import com.idbi.memorandum.dto.SearchFilterDTO;
import com.idbi.memorandum.dto.WorkflowDTO;
import com.idbi.memorandum.restServices.MemorandumRestService;

@RestController
@RequestMapping(value ="/api/memorandums")
public class MemorandumRestController 
{
	@Autowired 
	MemorandumRestService memorandumService;
	@PostMapping(value = "/record")
	public ResponseEntity<ResponseDTO> createMemorandum(@RequestBody MemorandumDTO memorandumDTO)
	{
		ResponseDTO responseDTO = memorandumService.createMemorandum(memorandumDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
	}
	
	@PostMapping(value = "/workflow") //update the status of the workflow
	public ResponseEntity<ResponseDTO> updateStatus(@RequestBody WorkflowDTO workflowDTO)
	{
		ResponseDTO responseDTO = memorandumService.updateStatus(workflowDTO);
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}
	
	@PostMapping(value = "/record/state") //delete and update the memorandum
	public ResponseEntity<ResponseDTO> updateMemorandum(@RequestBody MemorandumDTO memorandumDTO)
	{
		ResponseDTO responseDTO = memorandumService.updateMemorandum(memorandumDTO);
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}
	
	@PostMapping(value = "/criteria/list")
	public ResponseEntity<List<MemorandumDTO>> getMemorandumList(@RequestBody SearchFilterDTO serachFilterDTO)
	{
		return null;
	}
	
	@PostMapping(value = "/criteria/detail")
	public ResponseEntity<MemorandumDTO> getMemorandumById(@RequestBody SearchFilterDTO serachFilterDTO)
	{
		return null;
	}
}
