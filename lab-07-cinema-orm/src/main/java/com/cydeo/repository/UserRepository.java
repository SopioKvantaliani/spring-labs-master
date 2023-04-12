package com.cydeo.repository;

import com.cydeo.entity.AccountDetails;
import com.cydeo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <UserAccount, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    UserAccount findByEmail(String email);

    //Write a derived query to read a user with a username?
    UserAccount findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<UserAccount> findByUsernameContaining(String name);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List <UserAccount> findByUsernameContainingIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?
      List <UserAccount> findByAccountDetails_AgeGreaterThan(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?


    //Write a JPQL query that returns a user read by username?


    //Write a JPQL query that returns all users?


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?


    //Write a native query that returns all users?


    //Write a native query that returns all users in the range of ages?


    //Write a native query to read a user by email?
}
