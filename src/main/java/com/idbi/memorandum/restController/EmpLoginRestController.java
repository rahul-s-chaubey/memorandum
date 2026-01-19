package com.idbi.memorandum.restController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbi.memorandum.dto.EmpLoginRequestDto;
import com.idbi.memorandum.dto.EncryptedLoginRequestDto;
import com.idbi.memorandum.restServices.EmpAuthService;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/emp/auth")
public class EmpLoginRestController {

    @Autowired
    private EmpAuthService empAuthService;

    // ==========================
    // EXISTING LOGIN API
    // ==========================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody EmpLoginRequestDto request) {
        try {
            return ResponseEntity.ok(empAuthService.login(request));
        } catch (RuntimeException ex) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                        "error", ex.getMessage()
                    ));
        }

    }

    // ==========================
    // NEW ENCRYPTED LOGIN API
    // ==========================
    @PostMapping("/login-encrypted")
    public ResponseEntity<?> loginEncrypted(@RequestBody EncryptedLoginRequestDto request) {
        try {
            return ResponseEntity.ok(empAuthService.loginEncrypted(request));
        } catch (RuntimeException ex) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                        "error", ex.getMessage()
                    ));
        }

    }
    @GetMapping("/checkers")
    public ResponseEntity<?> getCheckers() {
        return ResponseEntity.ok(empAuthService.getEligibleCheckers());
    }

}
