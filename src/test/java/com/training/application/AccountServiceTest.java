package com.training.application;


import com.training.application.domain.Account;
import com.training.application.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountServiceTest {
    AccountService accountService = null;

    Account account = null;

    public void setup(){
        accountService=new AccountService();
        account = new Account();
    }

    @Test
    public void createAccount_Valid(){
        accountService.createAccount(account);
        Assertions.assertEquals(1,account.getId());
    }
    @Test
    public void createAccount_InValid(){
        assertThrows(InputMismatchException.class,()->accountService.createAccount(account));
    }
}

