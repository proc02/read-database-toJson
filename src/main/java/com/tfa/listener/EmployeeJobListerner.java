package com.tfa.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmployeeJobListerner implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info("Start to execute job..........");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		log.info("End to execute job ############ ");
	}

}
