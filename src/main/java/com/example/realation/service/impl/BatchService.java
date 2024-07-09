package com.example.realation.service.impl;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BatchService {

	private final JobLauncher jobLauncher;
	private final Job job;

	@Autowired
	public BatchService(JobLauncher jobLauncher, Job job) {
		super();
		this.jobLauncher = jobLauncher;
		this.job = job;
	}

	public void startJob() {
		try {
			System.out.println("running");
			jobLauncher.run(job,
					new JobParametersBuilder().addLong("startAt", System.currentTimeMillis()).toJobParameters());
		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();
		} catch (JobRestartException e) {
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		} 
	}

}