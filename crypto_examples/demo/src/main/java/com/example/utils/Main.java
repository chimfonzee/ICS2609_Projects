package com.example.utils;

public class Main {
    public static void main(String[] args) {
        //Initialize Object of Crypto
        //RSA crypto;
        AESCrypto crypto;
        String message = "something";
        byte[] encrypted = crypto.encrypt(message);
        System.out.println(encrypted);
        String decrypt = crypto.decrypt(encrypted);
        System.out.println(message.equals(decrypt));
    }
}
