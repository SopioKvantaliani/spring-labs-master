package com.cydeo.repository;

import com.cydeo.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository <AccountDetails, Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List <AccountDetails> findByCountryOrState(String country, String state);


    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List <AccountDetails> findByAgeIsLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role
     List <AccountDetails> findByRoleEquals(Enum role);

    //Write a derived query to list all accounts between a range of ages
    List <AccountDetails> findByAgeIsBetween(Integer startAge, Integer endAge);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<AccountDetails> findByAddressStartingWith(String patter);

    //Write a derived query to sort the list of accounts with age
    List <AccountDetails> findByAge(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts

    @Query ("select a from AccountDetails a")
    List <AccountDetails> retrieveAllAccounts ();

    //Write a JPQL query to list all admin accounts
    @Query("select a from AccountDetails a where a.role='ADMIN'")
    List <AccountDetails   > retrieveAllAdminAccounts (String role);

    //Write a JPQL query to sort all accounts with age
    @Query ("select a from AccountDetails a order by a.age")
     List<AccountDetails> sortAllAccountsWithAge (Integer age);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query (value = "select * from AccountDetails where age<= ?1", nativeQuery= true)
    List<AccountDetails> retrieveAllAccountsAgeLowerThanASpecificValue (Integer age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query (value = "select * from AccountDetails where name or address or state or city having ?1", nativeQuery = true)
    List<AccountDetails> retrieveAllAccountsWithSpecificValue (String pattern);

    //Write a native query to read all accounts with an age higher than a specific value
    @Query (value = "select * from AccountDetails where age>?1", nativeQuery = true)
    List<AccountDetails> retrieveAllAccountsWithAgeHigherThan (Integer age);
}
