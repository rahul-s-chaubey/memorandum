package com.idbi.memorandum.restServices;

import java.util.List;

import com.idbi.memorandum.dto.CommitteeDTO;
import com.idbi.memorandum.dto.ResponseDTO;
import com.idbi.memorandum.dto.SearchFilterDTO;

public interface CommitteeMasterService 
{
		ResponseDTO createCommittee(CommitteeDTO committeeDTO);
		
		 // UPDATE
	    ResponseDTO updateCommittee(CommitteeDTO committeeDTO);

	    // LIST
	    List<CommitteeDTO> getCommitteeList(SearchFilterDTO searchFilterDTO);

	    // DETAIL
	    CommitteeDTO getCommitteeById(SearchFilterDTO searchFilterDTO);
		
}
