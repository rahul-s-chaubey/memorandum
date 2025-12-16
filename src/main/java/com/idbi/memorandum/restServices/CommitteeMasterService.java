package com.idbi.memorandum.restServices;

import com.idbi.memorandum.dto.CommitteeDTO;
import com.idbi.memorandum.dto.ResponseDTO;

public interface CommitteeMasterService 
{
		ResponseDTO createCommittee(CommitteeDTO committeeDTO);
		
}
