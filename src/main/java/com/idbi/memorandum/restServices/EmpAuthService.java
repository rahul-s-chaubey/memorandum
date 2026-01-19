package com.idbi.memorandum.restServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbi.memorandum.dto.EmpLoginRequestDto;
import com.idbi.memorandum.dto.EmpLoginResponseDto;
import com.idbi.memorandum.dto.EncryptedLoginRequestDto;
import com.idbi.memorandum.entities.EmpEntity;
import com.idbi.memorandum.repositories.EmpRepository;
import com.idbi.memorandum.utility.JwtTokenUtil;
import com.idbi.memorandum.utility.RsaCryptoUtil;
import java.util.List;
import java.util.stream.Collectors;
import com.idbi.memorandum.dto.CheckerDTO;

@Service
public class EmpAuthService {

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private RsaCryptoUtil rsaCryptoUtil;

    // ==========================
    // EXISTING LOGIN (UNCHANGED)
    // ==========================
    public EmpLoginResponseDto login(EmpLoginRequestDto request) {

        EmpEntity emp = empRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials, try again"));

        if (!request.getPassword().equals(emp.getPassword())) {
            throw new RuntimeException("Invalid credentials, try again");
        }

        String token = jwtTokenUtil.generateToken(emp);

        return new EmpLoginResponseDto(token);


    }

    // ==========================
    // NEW ENCRYPTED LOGIN
    // ==========================
    public EmpLoginResponseDto loginEncrypted(EncryptedLoginRequestDto request) {

        // 1. Decrypt incoming payload using PRIVATE KEY
        String decryptedPayload = rsaCryptoUtil.decrypt(request.getEncryptedData());

        // Expected decrypted format:
        // email=user@idbi.com&password=12345
        String[] parts = decryptedPayload.split("&");

        String email = parts[0].split("=")[1];
        String password = parts[1].split("=")[1];

        // 2. SAME LOGIN LOGIC AS EXISTING METHOD
        EmpEntity emp = empRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials, try again"));

        if (!password.equals(emp.getPassword())) {
            throw new RuntimeException("Invalid credentials, try again");
        }

        String token = jwtTokenUtil.generateToken(emp);

        return new EmpLoginResponseDto(token);


    }
    
    public List<CheckerDTO> getEligibleCheckers() {

        return empRepository.findCheckersGradeCAndAbove()
                .stream()
                .map(e -> {
                    CheckerDTO dto = new CheckerDTO();
                    dto.setEin(e.getEin());
                    dto.setFullName(e.getFullNameTitle());
                    dto.setGrade(e.getGrade());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
