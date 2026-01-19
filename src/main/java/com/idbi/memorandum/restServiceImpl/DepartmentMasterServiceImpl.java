package com.idbi.memorandum.restServiceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbi.memorandum.dto.DepartmentDTO;
import com.idbi.memorandum.dto.ResponseDTO;
import com.idbi.memorandum.dto.SearchFilterDTO;
import com.idbi.memorandum.entities.DepartmentEntity;
import com.idbi.memorandum.repositories.DepartmentRepository;
import com.idbi.memorandum.restServices.DepartmentMasterService;

@Service
public class DepartmentMasterServiceImpl implements DepartmentMasterService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // CREATE
    @Override
    public ResponseDTO createDepartment(DepartmentDTO departmentDTO) {

        // NULL / EMPTY CHECK
        if (departmentDTO.getDepartmentName() == null ||
            departmentDTO.getDepartmentName().trim().isEmpty()) {

            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("FAILURE");
            responseDTO.setMessage("Department name cannot be empty");
            responseDTO.setMemorandumNumber(null);
            return responseDTO;
        }

        // DUPLICATE CHECK
        boolean exists =
                departmentRepository.existsByDepartmentName(
                        departmentDTO.getDepartmentName().trim());

        if (exists) {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("FAILURE");
            responseDTO.setMessage("Department already exists");
            responseDTO.setMemorandumNumber(null);
            return responseDTO;
        }

        DepartmentEntity entity = new DepartmentEntity();
        entity.setDepartmentName(departmentDTO.getDepartmentName().trim());
        entity.setDepartmentCode(departmentDTO.getDepartmentCode());
        entity.setCreatedBy(departmentDTO.getCreatedBy());
        entity.setCreatedOn(LocalDate.now());
        entity.setIsActive(true);   // ✅ default active

        DepartmentEntity savedEntity = departmentRepository.save(entity);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("SUCCESS");
        responseDTO.setMessage("Department created successfully");
        responseDTO.setMemorandumNumber(
                String.valueOf(savedEntity.getDepartmentId()));

        return responseDTO;
    }

    // UPDATE / SOFT DELETE
    @Override
    public ResponseDTO updateDepartment(DepartmentDTO departmentDTO) {

        DepartmentEntity entity = departmentRepository
                .findById(departmentDTO.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        if (departmentDTO.getDepartmentName() != null &&
            !departmentDTO.getDepartmentName().trim().isEmpty()) {
            entity.setDepartmentName(departmentDTO.getDepartmentName().trim());
            entity.setDepartmentCode(departmentDTO.getDepartmentCode());
        }

        if (departmentDTO.getIsActive() != null) {
            entity.setIsActive(departmentDTO.getIsActive());
        }

        entity.setUpdatedBy(departmentDTO.getUpdatedBy());
        entity.setUpdatedOn(LocalDate.now());

        departmentRepository.save(entity);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("SUCCESS");

        if (Boolean.FALSE.equals(departmentDTO.getIsActive())) {
            responseDTO.setMessage("Department deleted successfully");
        } else {
            responseDTO.setMessage("Department updated successfully");
        }

        responseDTO.setMemorandumNumber(
                String.valueOf(entity.getDepartmentId()));

        return responseDTO;
    }

    // LIST (ACTIVE ONLY)
    @Override
    public List<DepartmentDTO> getDepartmentList(SearchFilterDTO searchFilterDTO) {

        return departmentRepository.findByIsActiveTrue()
                .stream()
                .map(entity -> {
                    DepartmentDTO dto = new DepartmentDTO();
                    dto.setDepartmentId(entity.getDepartmentId());
                    dto.setDepartmentName(entity.getDepartmentName());
                    dto.setDepartmentCode(entity.getDepartmentCode());
                    dto.setCreatedBy(entity.getCreatedBy());
                    return dto;
                })
                .toList();
    }

    // DETAIL
    @Override
    public DepartmentDTO getDepartmentById(SearchFilterDTO searchFilterDTO) {

        DepartmentEntity entity = departmentRepository
                .findById(searchFilterDTO.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartmentId(entity.getDepartmentId());
        dto.setDepartmentName(entity.getDepartmentName());
        dto.setDepartmentCode(entity.getDepartmentCode());
        dto.setCreatedBy(entity.getCreatedBy());

        return dto;
    }
}

