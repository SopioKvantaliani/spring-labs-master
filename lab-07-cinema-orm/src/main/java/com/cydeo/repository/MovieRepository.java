package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface MovieRepository extends JpaRepository <Movie, Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    List<Movie> findByName (String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    //Write a derived query to list all movies where duration exists in the specific list of duration


    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findByReleaseDateGreaterThan(LocalDate startDate);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> findMovieByStateAndType (State state, Type type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("select m from Movie m where m.price between ?1 and ?2")
    List<Movie> listRangeOfPriceBetween (BigDecimal price1, BigDecimal price2);

    //Write a JPQL query that returns all movie names
    @Query ("select m.name FROM Movie m")
    List<String> listMovieName();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "select name from Movie where name=?1", nativeQuery = true)
    String retrieveMovieByName (String name);

    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "select * from Movie where price between ?1 and ?2", nativeQuery = true)
    List<Movie> retrieveMovieBetweenPriceRange (@Param("price") BigDecimal price1, @Param("price") BigDecimal price2);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "select * from Movie where duration between ?1 and ?2", nativeQuery = true)
    List <Movie> retrieveAllMoviesBetweenDuration (@Param("time") LocalTime time1, @Param("time") LocalTime time2);

    //Write a native query to list the top 5 most expensive movies

    @Query(value = "select * from Movie order by price desc limit 5", nativeQuery = true)
    List<Movie> top5Movie ( );
}
