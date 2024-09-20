package com.practice.demo.dao;

import com.practice.demo.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {

//    @Query("select m from HotelEntity m where m.hotelid=:id1 and m.hotelname=:name1 ")
    public List<HotelEntity> findByHotelidAndHotelname( int id,  String name);
}
