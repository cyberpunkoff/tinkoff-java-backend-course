package edu.hw8.task3.cracker;

import edu.hw8.task3.source.PasswordSource;
import java.util.Map;

public abstract class AbstractPasswordCracker {
    final PasswordSource passwordSource;

    public AbstractPasswordCracker(Map<String, String> accounts, PasswordSource passwordSource) {
        prepareAccounts(accounts);
        this.passwordSource = passwordSource;
    }

    abstract void prepareAccounts(Map<String, String> accounts);

    public abstract Map<String, String> recover();
}
