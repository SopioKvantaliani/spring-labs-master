package com.cydeo.repository;

import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieCinemaRepository extends JpaRepository <MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> findById (Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    List<MovieCinema> countByCinemaId (Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
     List <MovieCinema> countByMovieId(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findByDateTimeGreaterThan (LocalDateTime fromDate);

    //Write a derived query to find the top 3 expensive movies
    List <MovieCinema> findTop3ByMoviePrice (BigDecimal price);

    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findByMovieName (String name);

    //Write a derived query to list all movie cinemas in a specific location name
    List <MovieCinema> findByCinemaLocationName (String Name);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("select m from MovieCinema m where m.dateTime>?1")
    List<MovieCinema> retrieveCinemasHigherThanSpecificDate (LocalDateTime fromDate);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "select id, count (*)from MovieCinema group by id", nativeQuery = true)
    List<MovieCinema> countMovieCinemaBy(Long Id);

    //Write a native query that returns all movie cinemas by location name
    @Query (value = "select * from MovieCinema where Location = ?1", nativeQuery = true)
    List<MovieCinema> retrieveAllMoviesByLocationName (String locationName);

}
