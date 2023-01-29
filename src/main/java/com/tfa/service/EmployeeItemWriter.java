package com.tfa.service;

import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.tfa.entite.Employee;

@Component
public class EmployeeItemWriter extends JsonFileItemWriter<Employee> {
	private static JacksonJsonObjectMarshaller<Employee> jacksonJsonObjectMarshaller = new JacksonJsonObjectMarshaller<>();
	public EmployeeItemWriter(@Value("${com.tfa.remote}") boolean isResmoteFile) {
		super(gererResource(isResmoteFile), jacksonJsonObjectMarshaller);
		/*
		 * setJsonObjectMarshaller(jacksonJsonObjectMarshaller);
		 * EmployeeHeaderFooterCallback headerFooterCallback = new
		 * EmployeeHeaderFooterCallback(); setHeaderCallback(headerFooterCallback);
		 * setFooterCallback(headerFooterCallback);
		 */
	}
	
	private static Resource gererResource(boolean isRemoteFile) {
		return !isRemoteFile ? new FileSystemResource("data/output.json") : new FileSystemResource("data/output2.json");
	}
}
