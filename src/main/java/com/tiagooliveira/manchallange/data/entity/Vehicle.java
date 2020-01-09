package com.tiagooliveira.manchallange.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name="VEHICLE")
public class Vehicle {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="LICENSE")
    private String license;

    @Column(name="LAT")
    private BigDecimal lat;

    @Column(name="LNG")
    private BigDecimal lng;
}
