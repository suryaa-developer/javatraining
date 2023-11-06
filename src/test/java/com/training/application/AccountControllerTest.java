package com.training.application;



import com.training.application.controller.AccountController;
import com.training.application.domain.Account;
import com.training.application.service.AccountService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

public class AccountControllerTest {
    AccountController accountController = null;
    AccountService accountService = null;
    Account account = null;


    @BeforeEach
    public void setup() {
        accountService = new AccountService();
        accountController = new AccountController();
        account = new Account();
    }

    public void assertResponse(ResponseEntity response, HttpStatus httpStatus, String accountStatus) {
        assert response.getStatusCode() == httpStatus;
        assert response.getBody().equals(accountStatus);
    }

    @Test
    public void createAccount_created() {

        ResponseEntity response = accountController.createAccount(account);
        assertResponse(response, HttpStatus.CREATED, "Account created successfully");

    }

    @Test(expected = HttpClientErrorException.Conflict.class)
    public void createAccount_conflict() {

        ResponseEntity response = accountController.createAccount(account);
        assertResponse(response, HttpStatus.CONFLICT, "Account already exist");

    }

    @Test
    public void readAccount_Ok() {

        ResponseEntity response = accountController.readAccount(account.getId());
        assertResponse(response, HttpStatus.OK, "Given customer account is read successfully");

    }

    @Test
    public void readAccount_NotFound() {

        ResponseEntity response = accountController.readAccount(account.getId());
        assertResponse(response, HttpStatus.NOT_FOUND, "Given customer account is read successfully");

    }

    @Test(expected = HttpServerErrorException.ServiceUnavailable.class)
    public void readAccount_Unavailable() {

        ResponseEntity response = accountController.readAccount(account.getId());
        assertResponse(response, HttpStatus.SERVICE_UNAVAILABLE, "Account service unavailable");

    }

    @Test
    public void updateAccount_created() {

        ResponseEntity response = accountController.createAccount(account);
        assertResponse(response, HttpStatus.OK, "updated successfully");

    }

    @Test(expected = HttpClientErrorException.Conflict.class)
    public void updateAccount_conflict() {

        ResponseEntity response = accountController.createAccount(account);
        assertResponse(response, HttpStatus.ACCEPTED, "Accepted, fetching the details to the server");

    }

    @Test(expected = HttpServerErrorException.ServiceUnavailable.class)
    public void updateAccount_Unavailable() {

        ResponseEntity response = accountController.readAccount(account.getId());
        assertResponse(response, HttpStatus.SERVICE_UNAVAILABLE, "Account service unavailable");
    }

    @Test
    public void deleteAccount_Ok() {

        ResponseEntity response = accountController.readAccount(account.getId());
        assertResponse(response, HttpStatus.OK, "Given customer account is read successfully");

    }

    @Test
    public void deleteAccount_NotFound() {

        ResponseEntity response = accountController.readAccount(account.getId());
        assertResponse(response, HttpStatus.NOT_FOUND, "Given customer account is read successfully");

    }

    @Test(expected = HttpServerErrorException.ServiceUnavailable.class)
    public void deleteAccount_Unavailable() {

        ResponseEntity response = accountController.readAccount(account.getId());
        assertResponse(response, HttpStatus.SERVICE_UNAVAILABLE, "Account service unavailable");

    }
}
