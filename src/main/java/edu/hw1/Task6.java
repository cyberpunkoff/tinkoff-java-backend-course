package edu.hw1;

import java.util.Arrays;

public final class Task6 {
    private final static int K = 6174;

    private Task6() {
    }

    public static int countK(int n) {
        return countK(n, 0);
    }

    @SuppressWarnings("MagicNumber")
    private static int countK(int number, int count) {
        if (number == K) {
            return count;
        }

        String numberStr = Integer.toString(number);
        char[] digits = numberStr.toCharArray();
        Arrays.sort(digits);
        String sortedNumberStrAsc = new String(digits);
        int ascendingNumber = Integer.parseInt(sortedNumberStrAsc);
        char[] reversedDigits = new char[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversedDigits[i] = digits[digits.length - 1 - i];
        }
        String sortedNumberStrDesc = new String(reversedDigits);
        int descendingNumber = Integer.parseInt(sortedNumberStrDesc);

        return countK(
            Math.max(ascendingNumber, descendingNumber) - Math.min(ascendingNumber, descendingNumber),
            count + 1
        );
    }
}
