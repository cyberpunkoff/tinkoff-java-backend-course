package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonDatabaseImpl implements PersonDatabase {
    private final Map<Integer, Person> persons;
    private final Map<String, List<Person>> nameCache;
    private final Map<String, List<Person>> addressCache;
    private final Map<String, List<Person>> phoneCache;

    public PersonDatabaseImpl() {
        persons = new HashMap<>();
        nameCache = new HashMap<>();
        addressCache = new HashMap<>();
        phoneCache = new HashMap<>();
    }

    @Override
    public synchronized void add(Person person) {
        persons.put(person.id(), person);
        nameCache.computeIfAbsent(person.name(), k -> new ArrayList<>()).add(person);
        addressCache.computeIfAbsent(person.address(), k -> new ArrayList<>()).add(person);
        phoneCache.computeIfAbsent(person.phoneNumber(), k -> new ArrayList<>()).add(person);
    }

    @Override
    public synchronized void delete(int id) {
        Person personToDelete = persons.get(id);
        nameCache.get(personToDelete.name()).remove(personToDelete);
        addressCache.get(personToDelete.address()).remove(personToDelete);
        phoneCache.get(personToDelete.phoneNumber()).remove(personToDelete);
    }

    @Override
    public List<Person> findByName(String name) {
        return Optional.ofNullable(nameCache.get(name)).orElse(List.of());
    }

    @Override
    public List<Person> findByAddress(String address) {
        return Optional.ofNullable(addressCache.get(address)).orElse(List.of());
    }

    @Override
    public List<Person> findByPhone(String phone) {
        return Optional.ofNullable(phoneCache.get(phone)).orElse(List.of());
    }
}
