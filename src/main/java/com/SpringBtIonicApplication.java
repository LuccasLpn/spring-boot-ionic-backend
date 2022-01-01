package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.services.S3Service;

@SpringBootApplication
public class SpringBtIonicApplication implements CommandLineRunner{
	
	@Autowired
	private S3Service service;
	

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBtIonicApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		service.uploadFile("C:\\setup.jpeg");
		
	}
}
