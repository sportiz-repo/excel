package com.example.realation.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobExecutionListenerImpl implements JobExecutionListener {
	private Logger logger = LoggerFactory.getLogger(JobExecutionListenerImpl.class);

	@Override
	public void beforeJob(JobExecution jobExecution) {
		logger.info("Excel job started!");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED)
			logger.info("Excel job complted");
	}

}
