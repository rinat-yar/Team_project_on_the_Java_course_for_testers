package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.SavingAccount;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );

        account.add(3000);

        Assertions.assertEquals(5000, account.getBalance());
    }
}