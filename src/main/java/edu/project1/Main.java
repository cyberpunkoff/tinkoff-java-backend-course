package edu.project1;

import edu.project1.game.GameRunner;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        new GameRunner().setup();
    }
}
