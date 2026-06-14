package com.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class BusinessProjectApplication {

	public static void main(String[] args)
	{
		Dotenv dotenv = Dotenv.configure().directory("./").ignoreIfMalformed().ignoreIfMissing().load();
		
		if(dotenv.get("JDBC_DATABASE_URL") != null) {
			System.setProperty("JDBC_DATABASE_URL", dotenv.get("JDBC_DATABASE_URL"));
		}
		if(dotenv.get("JDBC_DATABASE_USERNAME") != null) {
			System.setProperty("JDBC_DATABASE_USERNAME", dotenv.get("JDBC_DATABASE_USERNAME"));
		}
		if(dotenv.get("JDBC_DATABASE_PASSWORD") != null) {
			System.setProperty("JDBC_DATABASE_PASSWORD", dotenv.get("JDBC_DATABASE_PASSWORD"));
		}
		 
		SpringApplication.run(BusinessProjectApplication.class, args);
	}
}