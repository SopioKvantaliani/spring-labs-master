package com.cydeo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Genre extends BaseEntity{

    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
