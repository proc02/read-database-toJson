package com.tfa.model;

import java.util.List;
import com.tfa.entite.Adresse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Employee {
	private String name;
	private double salary;
	private List<Adresse> adresses;
}
