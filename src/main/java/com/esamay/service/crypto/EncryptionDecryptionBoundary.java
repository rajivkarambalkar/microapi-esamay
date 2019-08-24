package com.esamay.service.crypto;

public interface EncryptionDecryptionBoundary {
    String encrypt(String plainText);

    String decrypt(String plainText);
}
