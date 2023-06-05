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
                4_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
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
                1_000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldNegativeInitialBalance() {
        CreditAccount account = new CreditAccount(
                -1000,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldZeroInitialBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPositiveInitialBalance() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldBalanceLessCreditLimit() {
        CreditAccount account = new CreditAccount(
                -10000,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldBalanceGreaterCreditLimit() {
        CreditAccount account = new CreditAccount(
                10000,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPositiveCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(5000, account.getCreditLimit());
    }

    @Test
    public void shouldZeroCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                0,
                15
        );

        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void shouldNegativeCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                -5_000,
                15
        );

        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void shouldPayPositive() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
        account.pay(1_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayNegative() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
        account.pay(10_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldPayNegativeMoney() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
        account.pay(-1_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldYearChangeNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -3_000,
                5_000,
                15
        );
        account.yearChange();

        Assertions.assertEquals(-450, account.yearChange());
    }

    @Test
    public void shouldYearChangePositiveBalance() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldYearChangeZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

}