package com.example.employee_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_service.model.EmployeeCreateRequest;
import com.example.employee_service.model.EmployeeResponse;
import com.example.employee_service.service.impl.EmployeeServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
  @Autowired
  private final EmployeeServiceImpl employeeService;
  private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

  public EmployeeController(EmployeeServiceImpl employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> create(@RequestBody @Valid EmployeeCreateRequest employeeCreateRequest) {
    EmployeeResponse employeeResponse = employeeService.createEmployee(employeeCreateRequest);
    // return employeeService.createEmployee(employeeCreateRequest);
    logger.info("Employee saved: {}", employeeResponse.toString());
    return ResponseEntity.ok("Employee added");
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<EmployeeResponse> getAllEmployees() {
    return employeeService.getEmployees();
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
  public EmployeeResponse findByEmployeeId(@PathVariable(value = "id") Integer id) {
    return employeeService.findByEmployeeId(id);
  }

  @DeleteMapping("{id}")
  public String deleteByEmployeeId(@PathVariable(value = "id") Integer id) {
    return employeeService.deleteByEmployeeId(id);
  }

}
