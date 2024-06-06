package com.example.employee_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_service.entity.Employee;

// repository can interaact with the database 
// the value passed into the generic method is the Employee entity and the integer is type of the primary key
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
