package com.tfa;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.tfa.entite.Employee;
import com.tfa.listener.EmployeeJobListerner;
import com.tfa.listener.EmployeeReaderListener;
import com.tfa.listener.EmployeeWriterListener;
import com.tfa.service.EmployeeCountItemStream;
import com.tfa.service.EmployeeItemReader;
import com.tfa.service.EmployeeItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private EmployeeItemReader employeeItemReader;
	@Autowired
	private EmployeeItemWriter employeeItemWriter;
	@Autowired
	private EmployeeReaderListener employeeReaderListener;
	@Autowired
	private EmployeeWriterListener employeeWriterListener;
	@Autowired
	private EmployeeJobListerner employeeJobListerner;

	@Bean
	public Job createJob() {
		return jobBuilderFactory.get("Job")
				.listener(employeeJobListerner)
				//.incrementer(new RunIdIncrementer())
				.flow(createStep())
				.end().build();
	}

	public Step createStep() {
		return stepBuilderFactory.get("My-Step")
			.<Employee,Employee>chunk(100)
			.reader(employeeItemReader)
			.listener(employeeReaderListener)
			.writer(employeeItemWriter)
			.stream(stream())
			.listener(employeeWriterListener)
			.taskExecutor(taskExecutor())
			.build();

	}
	
	public TaskExecutor taskExecutor(){
	    SyncTaskExecutor asyncTaskExecutor=new SyncTaskExecutor();
	    return asyncTaskExecutor;
	}
	@Bean
	public EmployeeCountItemStream stream() {
	  return new EmployeeCountItemStream();
	}
}
