package edu.hw7.task3;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class PersonDatabaseImplTest {
    @Test
    void testAddPerson() {
        List<Person> personList = List.of(
            new Person(1, "Maks", "hello", "+123"),
            new Person(2, "Maks2", "hello2", "+1234"),
            new Person(3, "Maks3", "hello3", "+1235")
        );
        PersonDatabase personDatabase = new PersonDatabaseImpl();

        Thread first = new Thread(() -> personList.forEach(personDatabase::add));
        Thread second = new Thread(() -> personList.forEach(
            person -> {
                synchronized (personDatabase) {
                    List<Person> foundByName = personDatabase.findByName(person.name());
                    List<Person> foundByAddress = personDatabase.findByAddress(person.address());
                    List<Person> foundByPhone = personDatabase.findByPhone(person.phoneNumber());

                    assertThat(foundByName).containsExactlyInAnyOrderElementsOf(foundByAddress);
                    assertThat(foundByAddress).containsExactlyInAnyOrderElementsOf(foundByPhone);
                }
            }
        ));

        first.start();
        second.start();

        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
