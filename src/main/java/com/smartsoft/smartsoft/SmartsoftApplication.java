package com.smartsoft.smartsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SmartsoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartsoftApplication.class, args);
	}

}
