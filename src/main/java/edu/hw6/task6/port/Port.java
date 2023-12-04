package edu.hw6.task6.port;

import java.util.Objects;

public class Port {
    public enum Type {
        TCP, UDP
    }

    private final int value;
    private Type type;
    private final String title;
    private final String description;

    public Port(int value, Type type, String title) {
        this.value = value;
        this.type = type;
        this.title = title;
        this.description = null;
    }


    public int getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Port port = (Port) o;
        return value == port.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
