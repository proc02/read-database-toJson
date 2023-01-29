package com.tfa.service;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeCountItemStream implements ItemStream {

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		log.info("Employee : "+executionContext.get("JdbcCursorItemReader.read.count"));
		
	}

	@Override
	public void close() throws ItemStreamException {
	}

}
