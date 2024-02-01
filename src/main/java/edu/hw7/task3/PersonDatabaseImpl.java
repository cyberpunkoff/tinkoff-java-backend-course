package edu.hw7.task3;

import java.util.List;

public class PersonDatabaseImpl extends AbstractPersonDatabase {
    @Override
    public synchronized void add(Person person) {
        super.add(person);
    }

    @Override
    public synchronized void delete(int id) {
        super.delete(id);
    }

    @Override
    public List<Person> findByName(String name) {
        return super.findByName(name);
    }

    @Override
    public List<Person> findByAddress(String address) {
        return super.findByAddress(address);
    }

    @Override
    public List<Person> findByPhone(String phone) {
        return super.findByPhone(phone);
    }
}
