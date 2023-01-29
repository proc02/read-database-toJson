package com.tfa;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ReadDatabaseToJsonApplication implements CommandLineRunner{
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;

	public static void main(String[] args) {
		SpringApplication.run(ReadDatabaseToJsonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.info("Batch job starting");
		JobParameters jobParameters = new JobParametersBuilder()
				.addString("time", format.format(Calendar.getInstance().getTime()))
				.addString("XSIZ", UUID.randomUUID().toString())
				.toJobParameters();
		jobLauncher.run(job, jobParameters);
		log.info("Batch job executed successfully\n");
	}
}
