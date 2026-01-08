package com.idbi.memorandum.restController;

import java.util.Base64;

import javax.crypto.Cipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbi.memorandum.utility.RsaKeyUtil;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/security")

public class SecurityKeyRestController {

    @Autowired
    private RsaKeyUtil rsaKeyUtil;

    @GetMapping("/public-key")
    public String getPublicKey() {
        return Base64.getEncoder()
                .encodeToString(rsaKeyUtil.getPublicKey().getEncoded());
    }

}
