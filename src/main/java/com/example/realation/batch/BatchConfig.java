package com.example.realation.batch;

import java.io.File;
import java.nio.file.Paths;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.realation.modal.Participant;
import com.example.realation.repo.MistakesInExcelRepo;
import com.example.realation.repo.ParticipantRepo;
import com.example.realation.util.ExcelParticipantReader;

@Configuration
public class BatchConfig {
	private final ParticipantRepo participantRepo;
	private final MistakesInExcelRepo mistakesInExcelRepo;

	@Autowired
	public BatchConfig(ParticipantRepo participantRepo, MistakesInExcelRepo mistakesInExcelRepo) {
		super();
		this.participantRepo = participantRepo;
		this.mistakesInExcelRepo = mistakesInExcelRepo;
	}

	@Bean
	public Job jobBean(JobRepository jobRepository, JobExecutionListenerImpl jobExecutionListenerImpl, Step step) {
		return new JobBuilder("excelDataprocessor", jobRepository).start(step).listener(jobExecutionListenerImpl)
				.build();
	}

	@Bean
	public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			ItemReader<Participant> itemReader, ItemProcessor<Participant, Participant> resultProcessor,
			ItemWriter<Participant> writer) {
		return new StepBuilder("resultJobStep", jobRepository).<Participant, Participant>chunk(10, transactionManager)
				.reader(itemReader).processor(resultProcessor).writer(writer).build();
	}

	@Bean
	public ItemReader<Participant> reader() {
		return new ExcelParticipantReader(Paths.get(Paths.get("").toAbsolutePath() + File.separator + "src"
				+ File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator
				+ "excel" + File.separator + "participants.xlsx").toString());
	}

	@Bean
	public ItemProcessor<Participant, Participant> processor() {
		return new ValidationProcessor(mistakesInExcelRepo);
	}

	@Bean
	public ItemWriter<Participant> writer() {
		return items -> participantRepo.saveAll(items);
	}
}
