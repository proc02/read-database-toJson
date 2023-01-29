package com.tfa.listener;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import com.tfa.entite.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmployeeWriterListener implements ItemWriteListener<Employee> {

	@Override
	public void beforeWrite(List<? extends Employee> items) {
		log.info("Start to write ===> ");
	}

	@Override
	public void afterWrite(List<? extends Employee> items) {
		log.info("End to write ===> ");
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Employee> items) {
		
	}

}
