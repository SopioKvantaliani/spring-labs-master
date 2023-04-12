package com.cydeo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserAccount extends BaseEntity{
    private String email;
    private String password;
    private String username;

    @OneToOne
    private AccountDetails accountDetails;

    //if we want to change field name we need to use @JoinColumn (name = "account_details_id")

    public UserAccount(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
