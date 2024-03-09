package com.example.utils;

import java.nio.charset.Charset;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class AESCryptoExample {
    public static void main(String[] args) throws Exception {
        String username = "username";
        String password = "password";
        IvParameterSpec spec = new IvParameterSpec(new byte[16]);

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, spec);
        byte[] encryptedMessage = cipher.doFinal(username.getBytes(Charset.defaultCharset()));
        
        for (int i = 0; i < encryptedMessage.length; i++)
            System.out.print(encryptedMessage[i]);
        System.out.println(String.format("\nEncrypted: %s", new String(encryptedMessage, Charset.forName("UTF-8"))));
    
        Cipher dCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        dCipher.init(Cipher.DECRYPT_MODE, secretKey, spec);
        byte[] decryptedMessage = dCipher.doFinal(encryptedMessage);
        System.out.println(String.format("\nDencrypted: %s", new String(decryptedMessage)));
    }
}
