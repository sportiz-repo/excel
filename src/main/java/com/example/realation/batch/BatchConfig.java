package com.example.realation.batch;

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
import com.example.realation.repo.ParticipantRepo;
import com.example.realation.util.ExcelParticipantReader;

@Configuration
public class BatchConfig {
	private final ParticipantRepo participantRepo;

	@Autowired
	public BatchConfig(ParticipantRepo participantRepo) {
		super();
		this.participantRepo = participantRepo;
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
		return new ExcelParticipantReader("sample-data.xlsx");
	}

}
