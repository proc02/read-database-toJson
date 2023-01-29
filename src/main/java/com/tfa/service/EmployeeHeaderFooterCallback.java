package com.tfa.service;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.item.file.FlatFileHeaderCallback;

import com.google.gson.stream.JsonWriter;

public class EmployeeHeaderFooterCallback implements FlatFileFooterCallback, FlatFileHeaderCallback {

	private static final String JSON_ROOT_NODE = "Employees";
	private JsonWriter jsonWriter;
	@Override
	public void writeHeader(Writer writer) throws IOException {
		this.jsonWriter = new JsonWriter(writer);
		jsonWriter.beginObject().name(JSON_ROOT_NODE).beginArray();
	}

	@Override
	public void writeFooter(Writer writer) throws IOException {
		jsonWriter.endArray().endObject();
		jsonWriter.close();
	}

}
