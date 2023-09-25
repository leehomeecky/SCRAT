package com.meecky.SCRAT.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Setter
@Getter
@Component
public class KeyProperty {
    private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;

    public KeyProperty(){
        KeyPair keyPairs = KeyGenerator.generateKey();
        this.publicKey = (RSAPublicKey) keyPairs.getPublic();
        this.privateKey = (RSAPrivateKey) keyPairs.getPrivate();
    }
}
