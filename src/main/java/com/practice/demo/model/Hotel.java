package com.practice.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    private Integer hotelId;
    private String hotelName;
    private String availableRoom;
    private Integer rating;
    private String address;
    private Double price;

}
