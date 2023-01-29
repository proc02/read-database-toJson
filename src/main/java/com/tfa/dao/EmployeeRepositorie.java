package com.tfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfa.entite.Employee;

public interface EmployeeRepositorie extends JpaRepository<Employee, Integer> {

}
