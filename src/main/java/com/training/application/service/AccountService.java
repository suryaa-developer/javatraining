package com.training.application.service;

import com.training.application.domain.Account;
import com.training.application.entity.AccountEntity;
import com.training.application.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.InputMismatchException;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public void createAccount(Account account) {
        int id = account.getId();
        if (id >= 1 && id <= 100) {
            System.out.println("Valid id, continue..");

            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setId(account.getId());
            accountEntity.setFirstName(account.getFirstName());
            accountEntity.setLastName(account.getLastName());
            accountEntity.setUserName(account.getUserName());
            accountEntity.setPhoneNumber(account.getPhoneNumber());
            accountEntity.setPassword(account.getPassword());
            accountEntity.setEmail(account.getEmail());

            accountEntity = accountRepository.save(accountEntity);
            id = accountEntity.getId();
            System.out.println("Customer is created");
        } else
            System.out.println("invalid input");
        throw new InputMismatchException();
    }

    public Account readAccount(int id) {

        Optional<AccountEntity> optionalCustomerEntity = accountRepository.findById(id);
        if (optionalCustomerEntity.isPresent()) {
            AccountEntity accountEntity = optionalCustomerEntity.get();
            System.out.println(accountEntity);

            Account account = new Account();
            account.setId(accountEntity.getId());
            account.setFirstName(accountEntity.getFirstName());
            account.setLastName(accountEntity.getLastName());
            account.setUserName(accountEntity.getUserName());
            account.setPhoneNumber(accountEntity.getPhoneNumber());
            account.setPassword(accountEntity.getPassword());
            account.setEmail(accountEntity.getEmail());

            return account;
        } else {
            System.out.println("There is no customer available with the give id " + id);
            return null;
        }

    }

    public void updateCustomer(Account account) {

        Optional<AccountEntity> optionalCustomerEntity = accountRepository.findById(account.getId());
        if (optionalCustomerEntity.isPresent()) {


            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setId(account.getId());
            accountEntity.setFirstName(account.getFirstName());
            accountEntity.setLastName(account.getLastName());
            accountEntity.setUserName(account.getUserName());
            accountEntity.setPhoneNumber(account.getPhoneNumber());
            accountEntity.setPassword(account.getPassword());
            accountEntity.setEmail(account.getEmail());

            accountRepository.save(accountEntity);

            System.out.println("updated in the table.");
        } else {
            System.out.println("Invalid input.");
            throw new InputMismatchException();
        }

    }
    public Account deleteAccount(int id) {
        Optional<AccountEntity> optionalCustomerEntity = accountRepository.findById(id);
        if (optionalCustomerEntity.isPresent()) {
            AccountEntity accountEntity = optionalCustomerEntity.get();


            Account account = new Account();

            account.setId(accountEntity.getId());
            account.setFirstName(accountEntity.getFirstName());
            account.setLastName(accountEntity.getLastName());
            account.setUserName(accountEntity.getUserName());
            account.setPhoneNumber(accountEntity.getPhoneNumber());
            account.setPassword(accountEntity.getPassword());
            account.setEmail(accountEntity.getEmail());
            accountRepository.deleteById(id);
            return account;
        } else {
            System.out.println("There is no customer with this id" + id);
            return null;
        }
    }
}
