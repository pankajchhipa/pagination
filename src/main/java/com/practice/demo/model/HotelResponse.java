package com.practice.demo.model;

import com.practice.demo.entity.HotelEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class HotelResponse {

    public List<HotelEntity> hotel;
    public Integer totalData;
}
