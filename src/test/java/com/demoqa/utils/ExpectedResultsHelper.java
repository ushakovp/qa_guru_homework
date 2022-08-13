package com.demoqa.utils;

import static java.lang.String.format;

public class ExpectedResultsHelper {

    public static String expectedDayOfBirth(String day, String month, String year) {
        return format("%s %s,%s", day, month, year);
    }

    public static String expectedSubjects(String[] subjects) {
        return String.join(", ", subjects);
    }

}
