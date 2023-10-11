package edu.hw1;

public final class Task7 {
    private Task7() {
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

}
