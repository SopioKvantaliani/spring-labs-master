package com.cydeo.repository;

import com.cydeo.entity.MovieCinema;
import com.cydeo.entity.Ticket;
import com.cydeo.entity.UserAccount;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {


    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought

//    List<Ticket> countTicketByUserAccountOrderBySeatNumber (Integer seatNumber);
    //Write a derived query to list all tickets by specific email
    List<Ticket> findDistinctByUserAccountEmailContaining(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
      List <Ticket> countByMovieCinema (Integer TicketCount);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findByDateTimeBetween (LocalDateTime startDate, LocalDateTime endDate);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("select t from Ticket t where t.userAccount.id=?1")
    List<Ticket> listAllTicketsBySpecificUser (UserAccount user);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("select t from Ticket t where t.dateTime between ?1 and ?2")
    List <Ticket> listAllTicketsBetweenRange (LocalDateTime date1, LocalDateTime date2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought

    @Query (value = "select count (*) from Ticket where UserAccount.id =?1", nativeQuery = true)
    Integer countOfTickets ( UserAccount id) ;


    //Write a native query to count the number of tickets a user bought in a specific range of dates

    @Query(value = "select count (*) from Ticket where UserAccount.id=?1 and dateTime >=?2 and dateTime=?3", nativeQuery = true)
    Integer countOfTicketsBetweenTimeRange (UserAccount id, LocalDateTime date1, LocalDateTime date2);


    //Write a native query to distinct all tickets by movie name

    @Query(value = "select mc.movieName from Ticket t JOIN MovieCinema mc on t.movieCinema.id=mc.id", nativeQuery = true)
    List<String> listAllDistinctTicketsByMovieName ();

    //Write a native query to find all tickets by user email
    @Query (value = " select * from Ticket t join UserAccount u on t.userAccount.id = u.id where u.email=?1", nativeQuery = true)
    List<Ticket> findAllTicketsByUserEmail (String email);

    //Write a native query that returns all tickets

    @Query(value = "select * from Ticket", nativeQuery = true)
    List<Ticket> returnAllTickets ();

    //Write a native query to list all tickets where a specific
    // value should be containable in the username or account name or movie name
    @Query (value = "select * from Ticket where userAccount.id like ?1 or accounName like ?2 or movieName ?3", nativeQuery = true)
    List <Ticket> listTicketsContainSpecialUsernameAccountMovieName (Long id, String accountName, String movieName);



}
