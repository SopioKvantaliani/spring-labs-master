package com.cydeo.entity;

import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Data
public class Movie extends BaseEntity{

    private String name;
    private BigDecimal price;
    @Enumerated (EnumType.STRING)
    private Type type;
    @Enumerated (EnumType.STRING)
    private State state;

    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;
    private Integer duration;
    @Column (columnDefinition = "text") //if we put 'text' we don't have character limit
    private String summary;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel", //when we say joinTable, we modify joinTable created by SpringBoot
            joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns =@JoinColumn(name = "genre_id")) //joinColumns changes column names in new table created by ManyToMany relationship
    private List<Genre> genre;

    public Movie(String name, BigDecimal price, Type type, State state, LocalDate releaseDate, Integer duration, String summary) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.state = state;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.summary = summary;
    }
}
