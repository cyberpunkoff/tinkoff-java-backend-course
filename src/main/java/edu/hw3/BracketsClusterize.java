package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class BracketsClusterize {
    private BracketsClusterize() {
    }

    public static List<String> clusterize(String input) {
        Stack<Character> brackets = new Stack<>();
        List<String> answer = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        for (char letter : input.toCharArray()) {
            temp.append(letter);
            if (letter == '(') {
                brackets.push(letter);
            } else {
                if (brackets.size() == 1) {
                    answer.add(temp.toString());
                    temp = new StringBuilder();
                }
                brackets.pop();
            }
        }

        return answer;
    }
}
