package com.tfa.listener;

import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

import com.tfa.entite.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmployeeReaderListener implements ItemReadListener<Employee> {

	@Override
	public void beforeRead() {
		log.info("Start to read database ===> ");
	}

	@Override
	public void afterRead(Employee item) {
		log.info("End to read database ===> ");
	}

	@Override
	public void onReadError(Exception ex) {
		
	}

}
