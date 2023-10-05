package edu.hw1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void helloWorld() {
        LOGGER.info("Hello, world!");
    }

    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(String duration) {
        Objects.requireNonNull(duration);

        String[] splitDuration = duration.split(":");

        if (splitDuration.length != 2) {
            return -1;
        }

        int seconds;
        int minutes;

        try {
            minutes = Integer.parseInt(splitDuration[0]);
            seconds = Integer.parseInt(splitDuration[1]);
        } catch (NumberFormatException e) {
            return -1;
        }

        if (seconds >= 60) {
            return -1;
        }

        return seconds + minutes * 60;
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

    public static int rotateRight(int n, int shift) {
        StringBuilder array = new StringBuilder(Integer.toBinaryString(n));

        for (int i = 0; i < shift; i++) {
            char temp = array.charAt(array.length() - 1);
            for (int j = array.length() - 1; j > 0; j--) {
                array.setCharAt(j, array.charAt(j - 1));
            }
            array.setCharAt(0, temp);
        }

        return Integer.parseInt(array.toString(), 2);
    }

    public static int rotateLeft(int n, int shift) {
        StringBuilder array = new StringBuilder(Integer.toBinaryString(n));

        for (int i = 0; i < shift; i++) {
            char temp = array.charAt(0);
            for (int j = array.length() - 1; j > 0; j--) {
                array.setCharAt(j - 1, array.charAt(j));
            }
            array.setCharAt(array.length() - 1, temp);
        }

        return Integer.parseInt(array.toString(), 2);
    }

    public static boolean isNestable(int[] firstArray, int[] secondArray) {
        Objects.requireNonNull(firstArray);
        Objects.requireNonNull(secondArray);

        int firstMin = firstArray[0];
        int firstMax = firstArray[0];
        int secondMin = secondArray[0];
        int secondMax = secondArray[0];

        for (int i = 1; i < firstArray.length; i++) {
            firstMin = Math.min(firstMin, firstArray[i]);
            firstMax = Math.max(firstMax, firstArray[i]);
        }

        for (int i = 1; i < secondArray.length; i++) {
            secondMin = Math.min(secondMin, secondArray[i]);
            secondMax = Math.max(secondMax, secondArray[i]);
        }

        return (firstMin > secondMin) && (firstMax < secondMax);
    }

    public static String fixString(String input) {
        Objects.requireNonNull(input);

        StringBuilder fixedString = new StringBuilder();

        for (int i = 1; i < input.length(); i += 2) {
            fixedString.append(input.charAt(i));
            fixedString.append(input.charAt(i - 1));
        }

        return fixedString.toString();
    }

    @SuppressWarnings("MagicNumber")
    public static boolean knightBoardCapture(int[][] deck) {
        Set<Map.Entry<Integer, Integer>> knights = new HashSet<>();
        for (int i = 0; i < deck.length; i++) {
            for (int j = 0; j < deck.length; j++) {
                if (deck[j][i] == 1) {
                    knights.add(Map.entry(i, j));
                }
            }
        }

        // восемь возможных ходов коня с текущей позиции
        int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
        int[] dy = {-2, -2, -1, 1, 2, 2, 1, -1};

        for (var knight : knights) {
            for (int i = 0; i < dx.length; i++) {
                int x = knight.getKey() + dx[i];
                int y = knight.getValue() + dy[i];

                if (knights.contains(Map.entry(x, y))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int countK(int n) {
        return countK(n, 0);
    }

    @SuppressWarnings("MagicNumber")
    private static int countK(int number, int count) {
        if (number == 6174) {
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

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        LOGGER.info("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 0; i <= 2; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            LOGGER.info("i = {}", i);
        }
    }
}
