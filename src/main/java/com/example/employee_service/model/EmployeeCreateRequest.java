package com.example.employee_service.model;

import com.example.employee_service.entity.Gender;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeCreateRequest {
  @Past(message = "birth data needs to be in the past")
  @NotNull
  private LocalDate birthDate;

  @PastOrPresent
  @NotNull
  private LocalDate hireDate;

  @NotEmpty
  private String firstName;

  @NotEmpty
  private String lastName;

  @NotNull
  private Gender gender;
}
