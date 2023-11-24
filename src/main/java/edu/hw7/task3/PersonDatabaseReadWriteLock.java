package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PersonDatabaseReadWriteLock implements PersonDatabase {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Map<Integer, Person> persons;
    private final Map<String, List<Person>> nameCache;
    private final Map<String, List<Person>> addressCache;
    private final Map<String, List<Person>> phoneCache;

    public PersonDatabaseReadWriteLock() {
        persons = new HashMap<>();
        nameCache = new HashMap<>();
        addressCache = new HashMap<>();
        phoneCache = new HashMap<>();
    }

    @Override
    public void add(Person person) {
        readWriteLock.writeLock().lock();
        persons.put(person.id(), person);
        nameCache.computeIfAbsent(person.name(), k -> new ArrayList<>()).add(person);
        addressCache.computeIfAbsent(person.address(), k -> new ArrayList<>()).add(person);
        phoneCache.computeIfAbsent(person.phoneNumber(), k -> new ArrayList<>()).add(person);
        readWriteLock.writeLock().unlock();
    }

    @Override
    public void delete(int id) {
        readWriteLock.writeLock().lock();
        Person personToDelete = persons.get(id);
        nameCache.get(personToDelete.name()).remove(personToDelete);
        addressCache.get(personToDelete.address()).remove(personToDelete);
        phoneCache.get(personToDelete.phoneNumber()).remove(personToDelete);
        readWriteLock.writeLock().unlock();
    }

    @Override
    public List<Person> findByName(String name) {
        readWriteLock.readLock().lock();
        List<Person> result = Optional.ofNullable(nameCache.get(name)).orElse(List.of());
        readWriteLock.readLock().unlock();
        return result;
    }

    @Override
    public List<Person> findByAddress(String address) {
        readWriteLock.readLock().lock();
        List<Person> result = Optional.ofNullable(addressCache.get(address)).orElse(List.of());
        readWriteLock.readLock().unlock();
        return result;
    }

    @Override
    public List<Person> findByPhone(String phone) {
        readWriteLock.readLock().lock();
        List<Person> result = Optional.ofNullable(phoneCache.get(phone)).orElse(List.of());
        readWriteLock.readLock().unlock();
        return result;
    }
}
