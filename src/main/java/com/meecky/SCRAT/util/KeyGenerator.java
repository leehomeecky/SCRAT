package com.meecky.SCRAT.util;

import lombok.extern.slf4j.Slf4j;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

@Slf4j
public class KeyGenerator {

    public static KeyPair generateKey(){
        KeyPair keyPair;

        try{
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        }
        catch (Exception e){
            log.error(e.getMessage());
            throw new IllegalStateException();
        }
        return keyPair;
    }
}
