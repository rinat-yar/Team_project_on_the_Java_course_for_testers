package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.CreditAccount;

public class CreditAccountTest {

    @Test
    public void shouldCreditAccount() {
        CreditAccount account = new CreditAccount(
                6_000,
                5_000,
                15
        );

        Assertions.assertEquals(5_000, account.getBalance());
    }


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
    public void shouldNegativeBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -5_000,
                    5_000,
                    15
            );
        });
    }

    @Test
    public void shouldNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    5_000,
                    -5_000,
                    15
            );
        });
    }

    @Test
    public void shouldNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    5_000,
                    5_000,
                    -15
            );
        });
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

    @Test
    public void TEST() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                -15
        );
    }

}