package com.example.employee_service.service;

import com.example.employee_service.model.EmployeeCreateRequest;
import com.example.employee_service.model.EmployeeResponse;

import jakarta.validation.Valid;

import java.util.*;

public interface EmployeeService {

  EmployeeResponse createEmployee(@Valid EmployeeCreateRequest employeeCreateRequest);

  List<EmployeeResponse> getEmployees();

  EmployeeResponse findByEmployeeId(Integer id);

  String deleteByEmployeeId(Integer id);
}
