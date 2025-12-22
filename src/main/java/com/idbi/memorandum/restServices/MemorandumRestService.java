package com.idbi.memorandum.restServices;

import java.util.List;

import com.idbi.memorandum.dto.MemorandumDTO;
import com.idbi.memorandum.dto.ResponseDTO;
import com.idbi.memorandum.dto.SearchFilterDTO;
import com.idbi.memorandum.dto.WorkflowDTO;

public interface MemorandumRestService 
{
	public ResponseDTO createMemorandum(MemorandumDTO memorandumDTO);
	
	public ResponseDTO updateStatus(WorkflowDTO workflowDTO);
	
	public ResponseDTO updateMemorandum(MemorandumDTO memorandumDTO);
	
	public MemorandumDTO getMemorandum(SearchFilterDTO serchFilterDTO);
	
	public List<MemorandumDTO> getMemorandumList(SearchFilterDTO searchFilterDTO);

	
//Pagination is pending	
}
