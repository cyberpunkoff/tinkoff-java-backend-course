package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task6 {
    private Task6() {
    }

    public static boolean isSubstring(String input, String search) {
        Pattern pattern = Pattern.compile(search);

        Matcher matcher = pattern.matcher(input);

        return matcher.find();
    }
}
