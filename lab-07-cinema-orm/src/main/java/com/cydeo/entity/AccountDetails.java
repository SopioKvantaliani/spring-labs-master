package com.cydeo.entity;

import com.cydeo.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class AccountDetails extends BaseEntity{

    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private Integer age;
    private String postal_code;

    @Enumerated (EnumType.STRING)
    private Role role;

    @OneToOne (mappedBy = "accountDetails") //to avoid two foreign key, we need to use mappedBy.
    private UserAccount userAccount;

    public AccountDetails(String name, String address, String country, String city, String state, Integer age, String postal_code) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.state = state;
        this.age = age;
        this.postal_code = postal_code;
    }
}
