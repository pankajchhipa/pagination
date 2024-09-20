package com.practice.demo.services;

import com.practice.demo.entity.UserEntity;
import com.practice.demo.model.HotelResponse;
import com.practice.demo.model.PageSize;
import com.practice.demo.entity.HotelEntity;

import java.util.List;

public interface HotelService {

    public HotelResponse getHotel(PageSize pageSize);
    public List<HotelEntity> getHotelByNameAndID(Integer id, String name);

    public String createUser(UserEntity user);

    }
