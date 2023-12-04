package edu.hw8.task3.cracker;

import edu.hw8.task3.source.PasswordSource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MultithreadPasswordCracker extends AbstractPasswordCracker {
    public static final int THREADS_AMOUNT = 4;
    private Map<String, String> passwordsToCrack;
    CountDownLatch latch = new CountDownLatch(THREADS_AMOUNT);
    ConcurrentHashMap<String, String> cracked = new ConcurrentHashMap<>();

    public MultithreadPasswordCracker(Map<String, String> accounts, PasswordSource passwordSource) {
        super(accounts, passwordSource);
    }

    @Override
    void prepareAccounts(Map<String, String> accounts) {
        passwordsToCrack = accounts.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    @Override
    public Map<String, String> recover() {
        ExecutorService threadPool = Executors.newFixedThreadPool(THREADS_AMOUNT);
        for (int i = 0; i < THREADS_AMOUNT; i++) {
            threadPool.execute(new Cracker());
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return cracked;
    }

    @SuppressWarnings("MagicNumber")
    class Cracker implements Runnable {
        @Override
        public void run() {
            while (!passwordSource.isEmpty()) {
                String password = passwordSource.nextPassword();

                if (password == null) {
                    break;
                }

                byte[] hash = new byte[0];
                try {
                    hash = MessageDigest.getInstance("MD5").digest(password.getBytes());
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
                String hashString = new BigInteger(1, hash).toString(16);

                if (passwordsToCrack.containsKey(hashString)) {
                    cracked.put(passwordsToCrack.get(hashString), password);
                }
            }

            latch.countDown();
        }
    }
}
