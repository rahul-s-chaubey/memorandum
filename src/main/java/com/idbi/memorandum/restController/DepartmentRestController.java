package com.idbi.memorandum.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbi.memorandum.dto.DepartmentDTO;
import com.idbi.memorandum.dto.ResponseDTO;
import com.idbi.memorandum.dto.SearchFilterDTO;
import com.idbi.memorandum.restServices.DepartmentMasterService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/departments")
public class DepartmentRestController {

    @Autowired
    private DepartmentMasterService departmentService;

    @PostMapping(value = "/record")
    public ResponseEntity<ResponseDTO> createDepartment(
            @RequestBody DepartmentDTO departmentDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(departmentService.createDepartment(departmentDTO));
    }

    @PostMapping(value = "/record/state")
    public ResponseEntity<ResponseDTO> updateDepartment(
            @RequestBody DepartmentDTO departmentDTO) {

        return ResponseEntity.ok(
                departmentService.updateDepartment(departmentDTO));
    }

    @PostMapping(value = "/criteria/list")
    public ResponseEntity<List<DepartmentDTO>> getDepartmentist(
            @RequestBody SearchFilterDTO serachFilterDTO) {

        return ResponseEntity.ok(
                departmentService.getDepartmentList(serachFilterDTO));
    }

    @PostMapping(value = "/criteria/detail")
    public ResponseEntity<DepartmentDTO> getDepartmentById(
            @RequestBody SearchFilterDTO serachFilterDTO) {

        return ResponseEntity.ok(
                departmentService.getDepartmentById(serachFilterDTO));
    }
}
