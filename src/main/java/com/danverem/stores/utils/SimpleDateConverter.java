package com.danverem.stores.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SimpleDateConverter {

    public static String dateToString(LocalDateTime date, String pattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

            return formatter.format(date);
        } catch (DateTimeParseException ex) {
            return LocalDateTime.now().toString();
        }
    }

    public static LocalDateTime stringToDate(String date, String pattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

            return LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException ex) {
            return LocalDateTime.now();
        }

    }
}
