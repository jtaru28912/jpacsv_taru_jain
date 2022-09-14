package com.assignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.assignment.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findByFirstName(String string);
//eMPLOYEE IS THE MODE/ENTITY CLASS AND DATATYPE OF PRIMARY KEY IS INTEGER

}
