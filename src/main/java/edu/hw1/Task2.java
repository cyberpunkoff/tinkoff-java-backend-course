package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    @SuppressWarnings("MagicNumber")
    public static int countDigits(int number) {
        int temp = Math.abs(number);
        int count = 1;

        while (temp > 9) {
            count++;
            temp /= 10;
        }

        return count;
    }
}
