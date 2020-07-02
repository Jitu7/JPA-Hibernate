package com.jyotirmayadas.jpae13sb.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
