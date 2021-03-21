package controller;

import dev.samstevens.totp.code.CodeGenerator;
import dev.samstevens.totp.code.CodeVerifier;
import dev.samstevens.totp.exceptions.CodeGenerationException;
import dev.samstevens.totp.exceptions.QrGenerationException;
import dev.samstevens.totp.qr.QrData;
import dev.samstevens.totp.qr.QrDataFactory;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.secret.SecretGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.GeneralSecurityException;

@org.springframework.web.bind.annotation.RestController
@Slf4j
public class RestController {
    @Autowired
    private SecretGenerator secretGenerator;

    @Autowired
    private QrDataFactory qrDataFactory;

    @Autowired
    private QrGenerator qrGenerator;

    @Autowired
    private CodeGenerator codeGenerator ;

    @Autowired
    private CodeVerifier codeVerifier ;

    @Autowired
    TotpUtils totpUtils ;
    @GetMapping("/get_code")
    public String getCode(@RequestParam String uid) throws GeneralSecurityException {
        if (uid != null ){
            String secret = "PVHMHLLMDBZQ4M6QVENRGFGDCSS35U33";
            String code = totpUtils.generateCurrentNumber(secret);
            return  code ;
        }
        return  null;
    }
}
