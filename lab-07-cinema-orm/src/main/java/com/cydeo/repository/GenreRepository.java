package com.cydeo.repository;

import com.cydeo.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository <Genre, Long> {
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres
    @Query ("select g from Genre g ")
    List<Genre> retrieveAllGenres ();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name
    @Query (value = "select * from Genre where name=?1 ", nativeQuery = true)
    List<Genre> retrieveAllGenresByName (String name);

}
