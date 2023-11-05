package edu.hw3.contacts;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class Contact implements Comparable<Contact> {
    private String name;
    private String surname;

    // Нормально ли делать парс имени и фамилии здесь? Или стоит вынести эту логику в другое место
    Contact(String fullName) {
        String[] nameParts = fullName.split(" ");

        if (nameParts.length == 1) {
            name = nameParts[0];
        } else if (nameParts.length == 2) {
            name = nameParts[0];
            surname = nameParts[1];
        } else {
            throw new IllegalArgumentException("Некорректный формат ФИО");
        }
    }

    Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public int compareTo(@NotNull Contact o) {
        /*
         * Если у контакта нет фамилии, то будет сравниваться его имя.
         * При этом у других контактов все также будет сравниваться фамилия.
         */
        if (this.surname == null || o.surname == null) {
            return this.name.compareTo(o.name);
        } else {
            return this.surname.compareTo(o.surname);
        }
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(surname, contact.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
