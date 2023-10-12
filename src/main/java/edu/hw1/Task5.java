package edu.hw1;

public final class Task5 {
    private Task5() {
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isPalindromeDescendant(int number) {
        String tempNumberString = String.valueOf(number);
        StringBuilder numberString = new StringBuilder(tempNumberString);

        if (numberString.length() < 2) {
            return false;
        }

        if (numberString.reverse().toString().equals(tempNumberString)) {
            return true;
        }

        int tempNumber = 0;
        if (numberString.length() % 2 == 0) {
            for (int i = 0; i <= numberString.length() - 2; i += 2) {
                tempNumber += Integer.parseInt(numberString.substring(i, i + 1));
                tempNumber += Integer.parseInt(numberString.substring(i + 1, i + 2));
                tempNumber *= 10;
            }
            tempNumber /= 10;
        } else {
            for (int i = 0; i < numberString.length() - 2; i += 2) {
                tempNumber += Integer.parseInt(numberString.substring(i, i + 1));
                tempNumber += Integer.parseInt(numberString.substring(i + 1, i + 2));
                tempNumber *= 10;
            }
            tempNumber += numberString.charAt(numberString.length() - 1);
        }

        return isPalindromeDescendant(tempNumber);
    }
}
