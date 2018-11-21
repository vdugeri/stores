package com.danverem.stores.utils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Matcher;

public class PasswordHash implements Hash {
    private int cost;
    SecureRandom random;

    public PasswordHash() {
        this(DEFAULT_COST);
    }

    public PasswordHash(int cost) {
        iterations(cost);
        this.cost = cost;
        this.random = new SecureRandom();
    }

    @Override
    public String hash(char[] password) {
        byte[] salt = new byte[SIZE / 8];
        random.nextBytes(salt);
        byte[] derivedKey = pbkdf2(password, salt, 1 << cost);
        byte[] hash = new byte[salt.length + derivedKey.length];
        System.arraycopy(salt, 0, hash, 0, salt.length);
        System.arraycopy(derivedKey, 0, hash, salt.length, derivedKey.length);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();

        return ID + cost  + '$' + encoder.encodeToString(hash);
    }

    @Override
    public boolean compare(char[] password, String token) {
        Matcher matcher = layout.matcher(token);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid password");
        }

        int iterations = iterations(Integer.parseInt(matcher.group(1)));
        byte[] hash = Base64.getUrlDecoder().decode(matcher.group(2));
        byte[] salt = Arrays.copyOfRange(hash, 0, SIZE / 8);
        byte[] check = pbkdf2(password, salt, iterations);

        int zero = 0;

        for (int i = 0; i < check.length; i++) {
            zero |= hash[salt.length + i] ^ check[i];
        }

        return zero == 0;
    }

    private static int iterations(int cost) {
        if ((cost < 0) || (cost > 30)) {
            throw new IllegalArgumentException("cost: " + cost);
        }

        return 1 << cost;
    }

    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations) {
        KeySpec spec = new PBEKeySpec(password, salt, iterations, SIZE);

        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            return keyFactory.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
