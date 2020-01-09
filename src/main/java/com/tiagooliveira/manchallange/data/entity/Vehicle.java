package com.tiagooliveira.manchallange.data.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }
}
