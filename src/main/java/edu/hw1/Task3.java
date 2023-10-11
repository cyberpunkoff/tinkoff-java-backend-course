package edu.hw1;

import java.util.Objects;

public final class Task3 {
    private Task3() {
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


}
