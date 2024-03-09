package com.example.utils;

import java.nio.charset.Charset;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

public class RSACryptoExample {
    public static void main(String args[]) throws Exception {
        String username = "username";

        //encryption
        KeyPairGenerator keypairGenerator = KeyPairGenerator.getInstance("RSA");
        keypairGenerator.initialize(2048);
        KeyPair pair = keypairGenerator.genKeyPair();
        
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
        byte[] encryptedMessage = cipher.doFinal(username.getBytes());
        
        System.out.println(new String(encryptedMessage, Charset.forName("UTF-8")));

        //decryption
        Cipher dCipher = Cipher.getInstance("RSA");
        dCipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
        byte[] decryptedMessage = dCipher.doFinal(encryptedMessage);
        System.out.println(new String(decryptedMessage, Charset.forName("UTF-8")));
    }
}
