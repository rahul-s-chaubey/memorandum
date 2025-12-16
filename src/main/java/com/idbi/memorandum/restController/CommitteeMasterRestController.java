package com.idbi.memorandum.restController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbi.memorandum.dto.CommitteeDTO;
import com.idbi.memorandum.dto.ResponseDTO;
import com.idbi.memorandum.dto.SearchFilterDTO;

@RestController
@RequestMapping(value ="/api/committees")
public class CommitteeMasterRestController 
{
	@PostMapping(value = "/record")
	public ResponseEntity<ResponseDTO> createCommitte(@RequestBody CommitteeDTO committeeDTO )
	{
		return null;
	}
	
	
	@PostMapping(value = "/record/state") //delete and update the memorandum
	public ResponseEntity<ResponseDTO> updateCommittee(@RequestBody CommitteeDTO committeeDTO)
	{
		return null;
	}
	
	
	@PostMapping(value = "/criteria/list")
	public ResponseEntity<List<CommitteeDTO>> getCommitteeList(@RequestBody SearchFilterDTO serachFilterDTO)
	{
		return null;
	}
	
	@PostMapping(value = "/criteria/detail")
	public ResponseEntity<CommitteeDTO> getCommitteeById(@RequestBody SearchFilterDTO serachFilterDTO)
	{
		return null;
	}
}
