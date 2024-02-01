package edu.hw10.task1;

import edu.hw10.task1.Max;
import edu.hw10.task1.Min;
import edu.hw10.task1.NotNull;

public record Amogus(@Min(5) @Max(20) int age, @NotNull String name, String surName) {
}
