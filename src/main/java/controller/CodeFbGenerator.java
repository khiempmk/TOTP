package controller;

import dev.samstevens.totp.code.CodeGenerator;
import dev.samstevens.totp.code.CodeVerifier;
import dev.samstevens.totp.code.DefaultCodeGenerator;
import dev.samstevens.totp.code.DefaultCodeVerifier;
import dev.samstevens.totp.exceptions.CodeGenerationException;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.GeneralSecurityException;

@SpringBootApplication
public class CodeFbGenerator {
    public static void main(String[] args) {
        new SpringApplication(CodeFbGenerator.class).run(args);
    }

    public static void main1(String[] args) throws CodeGenerationException, GeneralSecurityException {
        TimeProvider timeProvider = new SystemTimeProvider();
        CodeGenerator codeGenerator = new DefaultCodeGenerator();
        CodeVerifier verifier = new DefaultCodeVerifier(codeGenerator, timeProvider);
        String secret = "W3C5B3WKR4AUKFVWYU2WNMYB756OAKWY" ;
        System.out.println(timeProvider.getTime());
        String code = codeGenerator.generate(secret, timeProvider.getTime());
        boolean successful = verifier.isValidCode(secret, code);
        System.out.println(successful);


        TotpUtils totpUtils = new TotpUtils();
        String a = totpUtils.generateCurrentNumber("PVHMHLLMDBZQ4M6QVENRGFGDCSS35U33");
        System.out.println(a);
//        System.out.println(totpUtils.);

    }

}
