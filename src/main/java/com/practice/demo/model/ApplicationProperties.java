package com.practice.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "application1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationProperties {
    public String name;
    public String age;
    public String cost;



//    @Bean
//    @Profile("dev")
//    public String display(){
//        System.out.println(name +" "+ age+ " "+ cost);
//        return "null";
//    }
}
