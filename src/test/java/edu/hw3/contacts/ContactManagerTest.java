package edu.hw3.contacts;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class ContactManagerTest {
    static Stream<Arguments> contactManagerParameters() {
        return Stream.of(
            Arguments.of(
                List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"),
                "ASC",
                List.of(new Contact("Thomas", "Aquinas"), new Contact("Rene", "Descartes"), new Contact("David", "Hume"), new Contact("John", "Locke")
                )
            ),
            Arguments.of(
                List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss"),
                "DESC",
                List.of(new Contact("Carl Gauss"), new Contact("Leonhard Euler"), new Contact("Paul Erdos"))
            ),
            Arguments.of(Collections.emptyList(),
                "DESC",
                Collections.emptyList()
            ),
            Arguments.of(
                null,
                "DESC",
                Collections.emptyList()
            ),
            Arguments.of(
                List.of("Maks Aarly", "Alex", "Jane Smith"),
                "ASC",
                List.of(new Contact("Alex"), new Contact("Maks", "Aarly"), new Contact("Jane", "Smith"))
            )
        );
    }

    @ParameterizedTest
    @MethodSource("contactManagerParameters")
    void testContactManager(List<String> input, String order, List<Contact> expected) {
        ContactManager contactManager = new ContactManager();

        List<Contact> contacts = contactManager.parseContacts(input, order);

        assertThat(contacts).isEqualTo(expected);
    }
}
