package com.practice.demo.exceptions;

public class HotelNotFoundException extends Exception{

    public HotelNotFoundException(String message){
        super(message);
    }
}
