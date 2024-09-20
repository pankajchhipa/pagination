package com.practice.demo;

import com.practice.demo.model.ApplicationProperties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication

//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DemoApplication {

	@Autowired
	static ApplicationProperties applicationProperties;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println(applicationProperties);


	}

}
