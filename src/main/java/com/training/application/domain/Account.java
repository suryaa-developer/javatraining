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
    long phoneNumber;
    int password;
    String email;
    String createdBy;
    String updatedBy;
}
