package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.SavingAccount;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void testMaxBalance_1() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(8_000);

        Assertions.assertEquals(10_000, account.getBalance());
    }

    @Test // ++граничные значения, на 1 больше макс
    public void testMaxBalance_2() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(8_001);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test // ++граничные значения, на 1 меньше макс
    public void testMaxBalance_3() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(7_999);

        Assertions.assertEquals(9_999, account.getBalance());
    }

    @Test //++ прибавляем произвольное число, которое превышает лимит
    public void testMaxBalance_4() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(10_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test // ++негативное тестироване на прибавление отрицательного числа
    public void testNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(-1000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test // ++ списание произвольной отрицательной суммы
    public void testNegative_1() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-10_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test // ++ граничные значения по списанию
    public void testBoundaryValues() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test //++ граничные значения, на 1 меньше минимума
    public void testBoundaryValues_1() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_001);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test //++ граничные значения, на 1 больше минимума
    public void testBoundaryValues_2() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(999);

        Assertions.assertEquals(1_001, account.getBalance());
    }

    @Test
    public void testMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        Assertions.assertEquals(1000, account.getMinBalance());
    }

    @Test
    public void testMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        Assertions.assertEquals(10_000, account.getMaxBalance());
    }

    @Test
    public void testYearChange() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.yearChange();

        Assertions.assertEquals(2_100, account.yearChange());
    }

    @Test
    public void testPayMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean result = account.pay(1_000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void testPayBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean result = account.pay(500);

        Assertions.assertTrue(result);
        Assertions.assertEquals(1500, account.getBalance());
    }

    @Test
    public void testPayBalance_1() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean result = account.pay(2000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(0, account.getBalance());
    }


    @Test
    public void testNegativeValues() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            -2_000,
                            -1_000,
                            -10_000,
                            -5
                    );
                }
        );

    }

    @Test //++ граничные значения, на 1 больше минимума
    public void testPayNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(4000);

        Assertions.assertEquals(2000, account.getBalance());
    }

}