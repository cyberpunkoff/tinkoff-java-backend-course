package edu.hw8.task1;

import java.util.List;

public final class Insults {
    private final static String DEFAULT_INSULT = "...";
    private final static List<String> INSULTS = List.of(
        "Не переходи на личности там, где их нет",
        "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
        "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
        "Чем ниже интеллект, тем громче оскорбления"
    );

    private Insults() {
    }

    public static String getInsult(String keyWord) {
        return INSULTS.stream().filter(e -> e.contains(keyWord)).findAny().orElse(DEFAULT_INSULT);
    }
}
