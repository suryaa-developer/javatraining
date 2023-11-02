package com.training.application.controller;

import com.training.application.domain.Account;
import com.training.application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value= "/account-service/create-customer",method = RequestMethod.POST)
    public ResponseEntity createAccount(@RequestBody Account account) {

        try {
            accountService.createAccount(account);
            ResponseEntity response = new ResponseEntity("Account created successfully", HttpStatus.CREATED);
            return response;
        } catch (Exception exception) {
            ResponseEntity response = new ResponseEntity("Account already exist", HttpStatus.CONFLICT);
            return response;
        }
    }

    @RequestMapping(value= "/account-service/read-customer",method = RequestMethod.GET)
    public ResponseEntity readAccount(@RequestParam(name = "id") int id) {
        System.out.println(" Given customer id is" + id);
        Account account = accountService.readAccount(id);

        try {
            if (account == null) {
                ResponseEntity response = new ResponseEntity("Given customer id is not found", HttpStatus.NOT_FOUND);
                return response;
            } else {
                ResponseEntity response = new ResponseEntity("Given customer account is read successfully ", HttpStatus.OK);
                return response;
            }
        }catch (Exception exception) {
            ResponseEntity response = new ResponseEntity("Temporarily service unavailable",HttpStatus.SERVICE_UNAVAILABLE);
            return response;
        }
    }

    @RequestMapping(value= "/account-service/update-customer",method = RequestMethod.PUT)
    public ResponseEntity updateAccount(@RequestBody Account account) {


                try {
                    accountService.createAccount(account);
                    ResponseEntity response = new ResponseEntity("updated successfully", HttpStatus.OK);
                    return response;

                } catch (Exception exception) {
                    ResponseEntity response = new ResponseEntity("Temporarily service unavailable", HttpStatus.SERVICE_UNAVAILABLE);
                    return response;
                }
            }

    @RequestMapping(value= "/account-service/delete-customer",method = RequestMethod.DELETE)
    public ResponseEntity deleteAccount(@RequestParam (name = "id") int id) {
        System.out.println(" Given customer id is" + id);
        Account account = accountService.readAccount(id);
        try {
            if (account == null) {
                ResponseEntity response = new ResponseEntity("Given customer id is not found", HttpStatus.NOT_FOUND);
                return response;
            } else {
                ResponseEntity response = new ResponseEntity("Given customer id is deleted", HttpStatus.OK);
                return response;
            }
        }catch (Exception exception) {
            ResponseEntity response = new ResponseEntity("Temporarily service unavailable",HttpStatus.SERVICE_UNAVAILABLE);
            return response;
        }
    }

}
