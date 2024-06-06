package com.example.employee_service.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.model.EmployeeCreateRequest;
import com.example.employee_service.model.EmployeeResponse;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.service.EmployeeService;

import jakarta.validation.Valid;

@Service
@Validated
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;
  private final ModelMapper modelMapper;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
    this.employeeRepository = employeeRepository;
    this.modelMapper = modelMapper;
  }

  // convert between the employee and the actual repository

  @Override
  public EmployeeResponse createEmployee(@Valid EmployeeCreateRequest employeeCreateRequest) {
    Employee empReq = modelMapper.map(employeeCreateRequest, Employee.class);
    Employee savedEmployee = employeeRepository.save(empReq);

    return modelMapper.map(savedEmployee, EmployeeResponse.class);
  }

  @Override
  public List<EmployeeResponse> getEmployees() {
    return employeeRepository.findAll().stream()
        .map(e -> modelMapper.map(e, EmployeeResponse.class)).toList();
  }

  @Override
  public EmployeeResponse findByEmployeeId(Integer id) {
    return employeeRepository.findById(id).map(e -> modelMapper.map(e, EmployeeResponse.class))
        .orElseThrow((() -> new RuntimeException("Employee not found")));
  }

  @Override
  public String deleteByEmployeeId(Integer id) {
    try {
      if (employeeRepository.existsById(id)) {
        employeeRepository.deleteById(id);
        return "ok";
      } else {
        return "Employee with ID " + id + " not found";
      }
    } catch (Exception e) {
      return "An error occured while trying to delete the employee with ID " + id;
    }
  }
}
