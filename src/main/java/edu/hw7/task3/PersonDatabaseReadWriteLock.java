package edu.hw7.task3;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PersonDatabaseReadWriteLock extends AbstractPersonDatabase {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    @Override
    public void add(Person person) {
        readWriteLock.writeLock().lock();
        super.add(person);
        readWriteLock.writeLock().unlock();
    }

    @Override
    public void delete(int id) {
        readWriteLock.writeLock().lock();
        super.delete(id);
        readWriteLock.writeLock().unlock();
    }

    @Override
    public List<Person> findByName(String name) {
        try {
            readWriteLock.readLock().lock();
            return super.findByName(name);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        try {
            readWriteLock.readLock().lock();
            return super.findByAddress(address);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        try {
            readWriteLock.readLock().lock();
            return super.findByPhone(phone);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
