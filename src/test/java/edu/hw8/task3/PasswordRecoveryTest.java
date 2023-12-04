package edu.hw8.task3;

import edu.hw8.task3.cracker.AbstractPasswordCracker;
import edu.hw8.task3.cracker.PasswordCracker;
import edu.hw8.task3.source.GeneratorPasswordSource;
import edu.hw8.task3.source.PasswordSource;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class PasswordRecoveryTest {
    @Test
    void recoveryPasswordTest() {

        Map<String, String> dbDump = Map.of(
            "a.v.petrov", "e10adc3949ba59abbe56e057f20f883e",
            "v.v.belov", "d8578edf8458ce06fbc5bb76a58c5ca4",
            "a.s.ivanov", "482c811da5d5b4bc6d497ffa98491e38",
            "k.p.maslov", "5f4dcc3b5aa765d61d8327deb882cf99"
        );

        PasswordSource passwordSource = GeneratorPasswordSource.builder()
            .includeLowerCase(false)
            .passwordLength(3)
            .includeNumbers(true)
            .build();

//        PasswordSource passwordSource = new FilePasswordSource("rockyou.txt");


        AbstractPasswordCracker passwordCracker = new PasswordCracker(dbDump, passwordSource);

        System.out.println(passwordCracker.recover());


    }
}
