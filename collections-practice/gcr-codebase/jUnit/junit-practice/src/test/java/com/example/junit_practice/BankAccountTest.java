package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    BankAccount account = new BankAccount();

    @Test
    void testDeposit() {
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testWithdraw() {
        account.deposit(1000);
        account.withdraw(400);
        assertEquals(600, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        account.deposit(300);

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(500);
        });
    }
}

