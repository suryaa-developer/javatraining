package com.training.application.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@ToString
@Data
@Entity
@Table(name = "accountservice", schema = "account")
public class AccountEntity {

    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "firstName")
    String firstName;
    @Column(name = "lastName")
    String lastName;
    @Column(name = "userName")
    String userName;
    @Column(name = "phoneNumber")
    int PhoneNumber;
    @Column(name = "password")
    int password;
    @Column(name = "email")
    String email;

    @Column(name = "createdTime")
    @CreationTimestamp
    Timestamp createdTime;

    @Column(name = "updatedTime")
    @UpdateTimestamp
    Timestamp updatedTime;

    @Column(name = "createdBy")
    String createdBy;

    @Column(name = "updatedBy")
    String updatedBy;

}
