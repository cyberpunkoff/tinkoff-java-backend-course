package edu.hw5;

public final class Task8 {
    private Task8() {
    }

    /* Напишите регулярные выражения для строк из алфавита {0, 1}: */

    /* нечетной длины */
    public static boolean firstRegex(String input) {
        return input.matches("^[01]([01]{2})*$");
    }

    /* начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину */
    public static boolean secondRegex(String input) {
        return input.matches("^1[01]([01]{2})*$|^0([01]{2})*$");
    }

    /* количество 0 кратно 3 */
    public static boolean thirdRegex(String input) {
        return false;
    }

    /* любая строка, кроме 11 или 111 */
    public static boolean fourthRegex(String input) {
        return input.matches("^(?!11$|111$)[01]+$");
    }

    /* каждый нечетный символ равен 1 */
    public static boolean fifthRegex(String input) {
        return false;
    }

    /* содержит не менее двух 0 и не более одной 1 */
    public static boolean sixthRegex(String input) {
        return false;
    }

    /* нет последовательных 1 */
    public static boolean seventhRegex(String input) {
        return input.matches("^(?!.*11)[01]+$");
    }
}
