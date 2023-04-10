package com.cydeo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Integer remainingQuantity;

    @ManyToMany //when we use manyToMany always rename the table name;
    @JoinTable (name = "product_category_rel",
    joinColumns = @JoinColumn(name = "p_id"), inverseJoinColumns =@JoinColumn(name = "c_id"))
    private List <Category> categoryList;

    //@JoinColumn => refers to product
    //inverseJoinColumns = @JoinColumn refers to another table, in this case to Category

    //"rel" mean relationship table.
    /*we decided to put categoryList on product's side, because product might be 1000, while
    category might be max 3 to 10. So, logically it is better to bring relationship
    on products side.

    */


}
