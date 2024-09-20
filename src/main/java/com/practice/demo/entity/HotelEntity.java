package com.practice.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotel")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelEntity {

    @Id
    private Integer hotelid;
    @Column
    private String hotelname;
    @Column
    private String availableroom;
    @Column
    private Integer rating;
    @Column
    private String address;
    @Column
    private Double price;
}
