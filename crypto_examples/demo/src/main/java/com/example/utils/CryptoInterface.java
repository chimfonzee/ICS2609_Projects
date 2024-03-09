package com.example.utils;

public interface CryptoInterface {
    byte[] encrypt(String message);
    String decrypt(byte[] message);
}