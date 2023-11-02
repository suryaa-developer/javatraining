package com.training.application.domain;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Account {
    int id;
    String firstName;
   String lastName;
    String userName;
    int phoneNumber;
    int password;
    String email;
}
