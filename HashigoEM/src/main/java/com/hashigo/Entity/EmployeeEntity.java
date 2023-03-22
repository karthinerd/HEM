package com.hashigo.Entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class EmployeeEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
	
   @NotBlank
   @Size(max = 50)
   private String name;

   @NotNull
   @Min(18)
   private Integer age;

   @NotBlank
   private String position;

   @NotBlank
   private String role;

   @NotBlank
   @Email
   private String emailId;

   @NotBlank
   @Size(min = 8)
   private String password;

   @NotBlank
   @Pattern(regexp = "^\\d{10}$")
   private String phoneNumber;

}
