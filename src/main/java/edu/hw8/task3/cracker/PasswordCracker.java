package edu.hw8.task3.cracker;

import edu.hw8.task3.source.PasswordSource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PasswordCracker extends AbstractPasswordCracker {
    private Map<String, String> passwordsToCrack;
    private final Map<String, String> cracked;

    public PasswordCracker(Map<String, String> accounts, PasswordSource passwordSource) {
        super(accounts, passwordSource);
        this.cracked = new HashMap<>();
    }

    @Override
    void prepareAccounts(Map<String, String> accounts) {
        passwordsToCrack = accounts.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    @Override
    @SuppressWarnings("MagicNumber")
    public Map<String, String> recover() {
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

        return cracked;
    }
}
