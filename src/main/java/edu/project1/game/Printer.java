package edu.project1.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("MultipleStringLiterals")
public final class Printer {
    private final static Logger LOGGER = LogManager.getLogger();

    private Printer() {
    }

    private static final String STAGE_ZERO =
            "---+--\n"
        + "   | |\n"
        + "     |\n"
        + "     |\n"
        + "     |\n"
        + "_____|_____";
    private static final String STAGE_ONE =
        "---+--\n"
        + "  *| |\n"
        + "     |\n"
        + "     |\n"
        + "     |\n"
        + "_____|_____";
    private static final String STAGE_TWO =
        "---+--\n"
        + "  *| |\n"
        + "  |  |\n"
        + "  |  |\n"
        + "     |\n"
        + "_____|_____";
    private static final String STAGE_THREE =
        "---+--\n"
        + "  *| |\n"
        + " /|  |\n"
        + "  |  |\n"
        + "     |\n"
        + "_____|_____";
    private static final String STAGE_FOUR =
        "---+--\n"
        + "  *| |\n"
        + " /|\\ |\n"
        + "  |  |\n"
        + "     |\n"
        + "_____|_____";
    private static final String STAGE_FIVE =
        "---+--\n"
        + "  *| |\n"
        + " /|\\ |\n"
        + "  |  |\n"
        + " /   |\n"
        + "_____|_____";
    private static final String STAGE_SIX =
        "---+--\n"
        + "  *| |\n"
        + " /|\\ |\n"
        + "  |  |\n"
        + " / \\ |\n"
        + "_____|_____";
    private static final String[] GAME_STAGES =
        {STAGE_ZERO, STAGE_ONE, STAGE_TWO, STAGE_THREE, STAGE_FOUR, STAGE_FIVE, STAGE_SIX};

    public static void print(Session session) {
        print(session.getWord(), session.getMistakesCounter());
    }

    public static void print(Word word, int mistakesCounter) {
        StringBuilder buffer = new StringBuilder();

        LOGGER.info("\n" + GAME_STAGES[mistakesCounter]);

        buffer.append("+-+ ".repeat(Math.max(0, word.length())));
        LOGGER.info(buffer);
        buffer = new StringBuilder();

//        System.out.println();
        for (int i = 0; i < word.length(); i++) {
            buffer.append("|");
            if (word.isLetterGuessed(word.charAt(i))) {
               buffer.append(word.charAt(i));
            } else {
                buffer.append(" ");
            }
            buffer.append("| ");
        }
//        System.out.println();
        LOGGER.info(buffer);
        buffer = new StringBuilder();

        buffer.append("+-+ ".repeat(Math.max(0, word.length())));
        LOGGER.info(buffer);
//        System.out.println();
    }
}
