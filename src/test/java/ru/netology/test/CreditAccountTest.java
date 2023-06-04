package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.CreditAccount;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToMoreCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(6_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToMoreCreditLimitWhenBalanceGreaterZero() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(6_000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveMoneyWhenBalanceGreaterZero() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4000, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeMoneyWhenBalanceGreaterZero() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldAddToZeroMoneyWhenBalanceGreaterZero() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(1000, account.getBalance());
    }
}