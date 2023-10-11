package edu.hw1;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Task8 {
    private Task8() {
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
}
