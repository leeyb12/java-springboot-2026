package com.pknu26.studygroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pknu26.studygroup.config.FileProperties;

@SpringBootApplication
public class StudygroupApplication {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = encoder.encode("p@ssw0rd!");
		System.out.println("password - " + encoded);

		SpringApplication.run(StudygroupApplication.class, args);
		
		String uploadDir = new FileProperties().getUploadDir();
		System.out.println("uploadDir - " + uploadDir);
	}

}
