package com.idbi.memorandum.restController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbi.memorandum.dto.DepartmentDTO;
import com.idbi.memorandum.dto.ResponseDTO;
import com.idbi.memorandum.dto.SearchFilterDTO;

@RestController
@RequestMapping(value ="/api/departments")
public class DepartmentRestController {
	

	@PostMapping(value = "/record")
	public ResponseEntity<ResponseDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO)
	{
		return null;
	}
	
	
	
	@PostMapping(value = "/record/state") //delete and update the memorandum
	public ResponseEntity<ResponseDTO> updateDepartment(@RequestBody DepartmentDTO departmentDTO)
	{
		return null;
	}
	
	
	@PostMapping(value = "/criteria/list")
	public ResponseEntity<List<DepartmentDTO>> getDepartmentist(@RequestBody SearchFilterDTO serachFilterDTO)
	{
		return null;
	}
	
	@PostMapping(value = "/criteria/detail")
	public ResponseEntity<DepartmentDTO> getDepartmentById(@RequestBody SearchFilterDTO serachFilterDTO)
	{
		return null;
	}

	
}
