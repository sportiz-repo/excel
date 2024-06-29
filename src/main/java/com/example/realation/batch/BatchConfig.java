package com.example.realation.batch;

import java.io.File;
import java.nio.file.Paths;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.example.realation.modal.Participant;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {
	
	@Bean
	public FlatFileItemReader<Participant> itemReader(){
		FlatFileItemReader<Participant> itemReader = new FlatFileItemReader<Participant>();
		itemReader.setResource(new FileSystemResource(Paths.get(Paths.get("").toAbsolutePath() + 
				File.separator + "src" + 
				File.separator + "main"+ 
				File.separator + "resources" + 
				File.separator + "static" + 
				File.separator + "excel" +
				File.separator +
				"participants.xlsx")));
		itemReader.setName("participant reader");
		return itemReader;
		
	}

}
