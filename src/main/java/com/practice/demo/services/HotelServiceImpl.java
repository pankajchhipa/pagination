package com.practice.demo.services;

import com.practice.demo.dao.HotelRepository;
import com.practice.demo.dao.UserRepository;
import com.practice.demo.entity.UserEntity;
import com.practice.demo.model.HotelResponse;
import com.practice.demo.model.PageSize;
import com.practice.demo.entity.HotelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository repository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
//    @Autowired
//     ApplicationProperties applicationProperties;

    @Override
    public HotelResponse getHotel(PageSize pageSize) {
        Pageable paging = PageRequest.of(pageSize.getPage(), pageSize.getSize(),
                Sort.by("hotelid").ascending());
        Page<HotelEntity> pagedResult = repository.findAll(paging);

        List<HotelEntity> objects = pagedResult.hasContent() ? pagedResult.getContent() : List.of();
        List<HotelEntity> all = repository.findAll();
        return  HotelResponse.builder().hotel(objects).totalData(all.size()).build();
    }

    @Override
    public List<HotelEntity> getHotelByNameAndID(Integer id, String name) {
        //System.out.println(applicationProperties);
        return repository.findByHotelidAndHotelname(id, name);
    }

    @Override
    public String createUser(UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity save = userRepository.save(user);
        if(save!=null){
            return "UserCreated Suceessfully";
        }

        return "User Already there";
    }
}
