package com.tfa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Adresse {

	private String addresse;
	private Employee employee;
}
