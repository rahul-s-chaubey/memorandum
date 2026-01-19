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

import com.idbi.memorandum.dto.CommitteeDTO;
import com.idbi.memorandum.dto.ResponseDTO;
import com.idbi.memorandum.dto.SearchFilterDTO;
import com.idbi.memorandum.restServices.CommitteeMasterService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/committees")
public class CommitteeMasterRestController {

    @Autowired
    private CommitteeMasterService committeeMasterService;

    // CREATE
    @PostMapping(value = "/record")
    public ResponseEntity<ResponseDTO> createCommitte(
            @RequestBody CommitteeDTO committeeDTO) {

        ResponseDTO responseDTO =
                committeeMasterService.createCommittee(committeeDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    // UPDATE (state change)
    @PostMapping(value = "/record/state")
    public ResponseEntity<ResponseDTO> updateCommittee(
            @RequestBody CommitteeDTO committeeDTO) {

        ResponseDTO responseDTO =
                committeeMasterService.updateCommittee(committeeDTO);

        return ResponseEntity.ok(responseDTO);
    }

    // LIST
    @PostMapping(value = "/criteria/list")
    public ResponseEntity<List<CommitteeDTO>> getCommitteeList(
            @RequestBody SearchFilterDTO serachFilterDTO) {

        List<CommitteeDTO> list =
                committeeMasterService.getCommitteeList(serachFilterDTO);

        return ResponseEntity.ok(list);
    }

    // DETAIL BY ID
    @PostMapping(value = "/criteria/detail")
    public ResponseEntity<CommitteeDTO> getCommitteeById(
            @RequestBody SearchFilterDTO serachFilterDTO) {

        CommitteeDTO dto =
                committeeMasterService.getCommitteeById(serachFilterDTO);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/test")
    public String hello() {
        return "Working API";
    }
}
