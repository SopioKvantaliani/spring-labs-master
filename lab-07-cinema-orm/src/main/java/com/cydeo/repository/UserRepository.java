package com.cydeo.repository;

import com.cydeo.entity.AccountDetails;
import com.cydeo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface UserRepository extends JpaRepository <UserAccount, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    UserAccount findByEmail (String email);

    //Write a derived query to read a user with a username?
    UserAccount findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<UserAccount> findByUsernameContaining(String name);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List <UserAccount> findByUsernameContainingIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("select u from UserAccount u where u.email=?1")
    UserAccount returnByEmail (String email);

    //Write a JPQL query that returns a user read by username?
    @Query("select u from UserAccount u where u.username=?1")
    UserAccount returnByUserName (String Username);

    //Write a JPQL query that returns all users?
    @Query("select u from UserAccount u")
    List <UserAccount> returnAllUsers ();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?

    @Query(value = "select * from UserAccount where username like ?1", nativeQuery = true)
    List <UserAccount> retrieveAllUsersWithSpecificName (String name);

    //Write a native query that returns all users?
    @Query(value = "select * from UserAccount", nativeQuery = true)
    List<UserAccount> returnUsers ();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "select * from UserAccount ua join AccountDetails ad " +
            "on ua.accountDetails.id = ad.id where ad.age between ?1 and ?2", nativeQuery = true)
    List <UserAccount> returnAllUsersBetweenAgeRange (BigDecimal age1, BigDecimal age2);

    //Write a native query to read a user by email?
    @Query(value = "select * from UserAccount where username=?1",nativeQuery = true)
    UserAccount returnUserByEmail (@Param("username") String email);
}
