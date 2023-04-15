package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Data
public class Location extends BaseEntity {

    @NonNull
    private String name;
    //    private String latitude;
    //    private String longitude;
    private String address;
    private String postalCode;
    private String country;
    private String state;
    private String city;

    public Location(@NonNull String name, String address, String postalCode, String country, String state, String city) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.country = country;
        this.state = state;
        this.city = city;
    }
}
