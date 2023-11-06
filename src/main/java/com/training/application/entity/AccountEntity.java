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
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "user_name")
    String userName;
    @Column(name = "phone_number")
    long PhoneNumber;
    @Column(name = "password")
    int password;
    @Column(name = "email")
    String email;

    @Column(name = "created_time")
    @CreationTimestamp
    Timestamp createdTime;

    @Column(name = "updated_time")
    @UpdateTimestamp
    Timestamp updatedTime;

    @Column(name = "created_by")
    String createdBy;

    @Column(name = "updated_by")
    String updatedBy;

}
