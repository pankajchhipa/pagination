package com.practice.demo.controller;


import com.practice.demo.entity.UserEntity;
import com.practice.demo.model.HotelResponse;
import com.practice.demo.model.JWTUserPayload;
import com.practice.demo.model.PageSize;
import com.practice.demo.entity.HotelEntity;
import com.practice.demo.exceptions.HotelNotFoundException;
import com.practice.demo.services.HotelService;
import com.practice.demo.services.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/home")
@CrossOrigin(value = "http://localhost:4200/")
public class HomeController {

    private static  final Logger logger =LoggerFactory.getLogger(HomeController.class);
    final HotelService service;

    @Autowired
    public HomeController(final HotelService service){
        this.service = service;
    }

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    public JwtService jwtService;

//    @Value("${application1.name}")
//    String name;
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/gethotel")
    public HotelResponse getHotel(@RequestBody PageSize pageSize){

        return service.getHotel(pageSize);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "/hotelbyid/{id}/{name}")
    public ResponseEntity<List<HotelEntity>> getHotel(@PathVariable(value = "id") Integer id1, @PathVariable(value = "name") String name1 ) throws HotelNotFoundException {
        List<HotelEntity> hotelByNameAndID = service.getHotelByNameAndID(id1, name1);
        if(hotelByNameAndID.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<HotelEntity>());
            throw new HotelNotFoundException("Hotel Is not found for id : " + id1 + " and Name : "+ name1 );
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(hotelByNameAndID);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createUser(@RequestBody UserEntity user){

        String user1 = service.createUser(user);
        return ResponseEntity.status(HttpStatus.OK)
                .body(user1);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody JWTUserPayload authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
