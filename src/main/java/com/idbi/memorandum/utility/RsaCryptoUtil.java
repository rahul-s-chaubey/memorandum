package com.idbi.memorandum.utility;

import java.security.spec.MGF1ParameterSpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RsaCryptoUtil {

    @Autowired
    private RsaKeyUtil rsaKeyUtil;

    public String decrypt(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");

            OAEPParameterSpec oaepParams = new OAEPParameterSpec(
                    "SHA-256",               // message digest
                    "MGF1",                  // mask generation
                    MGF1ParameterSpec.SHA256,// MGF digest
                    PSource.PSpecified.DEFAULT
            );

            cipher.init(
                    Cipher.DECRYPT_MODE,
                    rsaKeyUtil.getPrivateKey(),
                    oaepParams
            );

            byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);

            return new String(decryptedBytes);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to decrypt payload");
        }
    }



}
