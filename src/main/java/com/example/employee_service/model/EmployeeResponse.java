package com.example.employee_service.model;

import com.example.employee_service.entity.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class EmployeeResponse {
  private Integer employeeNumber;
  private LocalDate birthDate;
  private LocalDate hireDate;
  private String firstName;
  private String lastName;
  private Gender gender;

  public EmployeeResponse() {
  }
}
