package com.idbi.memorandum.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.idbi.memorandum.delegator.ArnDelegatorService;
import com.idbi.memorandum.dto.*;

@RestController
@RequestMapping(value = "/api/memorandums")
public class ArnRestController {

    @Autowired
    private ArnDelegatorService arnDelegatorService;

    @PostMapping(value = "/record")
    public ResponseEntity<ResponseDTO> createMemorandum(
            @RequestBody MemorandumDTO memorandumDTO) {

        ResponseDTO responseDTO =
                arnDelegatorService.createDocument(memorandumDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PostMapping(value = "/workflow")
    public ResponseEntity<ResponseDTO> updateStatus(
            @RequestBody WorkflowDTO workflowDTO) {

        ResponseDTO responseDTO =
                arnDelegatorService.updateWorkflow(workflowDTO);

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping(value = "/record/state")
    public ResponseEntity<ResponseDTO> updateMemorandum(
            @RequestBody MemorandumDTO memorandumDTO) {

        ResponseDTO responseDTO =
                arnDelegatorService.updateDocument(memorandumDTO);

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping(value = "/criteria/list")
    public ResponseEntity<List<MemorandumDTO>> getMemorandumList(
            @RequestBody SearchFilterDTO searchFilterDTO) {

        List<MemorandumDTO> list =
                arnDelegatorService.getDocumentList(searchFilterDTO);

        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/criteria/detail")
    public ResponseEntity<MemorandumDTO> getMemorandumById(
            @RequestBody SearchFilterDTO searchFilterDTO) {

        MemorandumDTO dto =
                arnDelegatorService.getDocumentDetail(searchFilterDTO);

        return ResponseEntity.ok(dto);
    }
}
