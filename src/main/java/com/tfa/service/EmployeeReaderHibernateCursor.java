package com.tfa.service;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.HibernateCursorItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tfa.entite.Employee;
import com.tfa.service.EmployeeItemReader.EmployeeRowMapper;

import lombok.extern.slf4j.Slf4j;


public class EmployeeReaderHibernateCursor extends HibernateCursorItemReader<Employee> implements ItemReader<Employee> {

	public EmployeeReaderHibernateCursor(DataSource dataSource,@Value("${employee.sql}") String request) {
		
	}
}
