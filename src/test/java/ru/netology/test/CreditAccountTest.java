package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.CreditAccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreditAccountTest {

    @Test
    public void shouldCreditAccount() {
        try {
            CreditAccount account = new CreditAccount(
                    6_000,
                    5_000,
                    15
            );
            Assertions.fail("IllegalArgumentException not thrown");
        } catch (IllegalArgumentException expected) {

        }
    }


    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(0);

        assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-3_000);

        assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToMoreCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(6_000);

        assertEquals(6000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveMoneyWhenBalanceGreaterZero() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(3_000);

        assertEquals(4000, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeMoneyWhenBalanceGreaterZero() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(-3_000);

        assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldAddToZeroMoneyWhenBalanceGreaterZero() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(0);

        assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldPositiveCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        assertEquals(5000, account.getCreditLimit());
    }

    @Test
    public void shouldZeroCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                0,
                15
        );

        assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void shouldNegativeBalance() {
        assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -5_000,
                    5_000,
                    15
            );
        });
    }

    @Test
    public void shouldNegativeCreditLimit() {
        assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    5_000,
                    -5_000,
                    15
            );
        });
    }

    @Test
    public void shouldNegativeRate() {
        assertThrows(IllegalArgumentException.class, () -> {
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

        assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayNegative() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
        account.pay(10_000);

        assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldPayNegativeMoney() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
        account.pay(-1_000);

        assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldYearChangeNegativeBalance() {
        try {
            CreditAccount account = new CreditAccount(
                    -3_000,
                    5_000,
                    15
            );
            account.yearChange();
            Assertions.fail("IllegalArgumentException not thrown");
        } catch (IllegalArgumentException expected) {

        }
    }

    @Test
    public void shouldYearChangePositiveBalance() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
        account.yearChange();

        assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldYearChangeZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.yearChange();

        assertEquals(0, account.yearChange());
    }
}