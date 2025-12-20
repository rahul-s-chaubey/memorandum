package com.idbi.memorandum.restServices;

import java.util.List;

import com.idbi.memorandum.dto.DepartmentDTO;
import com.idbi.memorandum.dto.ResponseDTO;
import com.idbi.memorandum.dto.SearchFilterDTO;

public interface DepartmentMasterService {

    ResponseDTO createDepartment(DepartmentDTO departmentDTO);

    ResponseDTO updateDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getDepartmentList(SearchFilterDTO searchFilterDTO);

    DepartmentDTO getDepartmentById(SearchFilterDTO searchFilterDTO);
}
