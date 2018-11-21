package com.danverem.stores.utils;

import java.util.regex.Pattern;

public interface Hash {

    int DEFAULT_COST = 16;

    String ID = "$31$";

    String ALGORITHM = "PBKDF2WithHmacSHA1";

    int SIZE = 128;

    Pattern layout = Pattern.compile("\\$31\\$(\\d\\d?)\\$(.{43})");

    String hash(char[] password);

    boolean compare(char[] password, String token);
}
