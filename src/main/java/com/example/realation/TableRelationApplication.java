package com.example.realation;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TableRelationApplication {

	public static void main(String[] args) {
		Path path = Paths.get(Paths.get("").toAbsolutePath() + File.separator + "src" + File.separator + "resources"
				+ File.separator + "main" + File.separator + "participant_excel");
		System.out.println(Paths.get(Paths.get("").toAbsolutePath() + File.separator + "src" + File.separator + "resources"
				+ File.separator + "main" + File.separator + "participant_excel"));
		
		SpringApplication.run(TableRelationApplication.class, args);
	}

}
