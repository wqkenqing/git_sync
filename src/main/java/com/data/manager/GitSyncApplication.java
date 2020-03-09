package com.data.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SpringBootConfiguration
//@EnableScheduling
public class GitSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitSyncApplication.class, args);
	}

}
