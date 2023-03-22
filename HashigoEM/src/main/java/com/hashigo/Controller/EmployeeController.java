/**
 * 
 */
package com.hashigo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hashigo.Entity.EmployeeEntity;
import com.hashigo.LoginDto.LoginRequest;
import com.hashigo.Response.LoginResponse;
import com.hashigo.Service.EmployeeService;

import jakarta.validation.Valid;

/**
 * @author karth
 *
 */
@RestController
@RequestMapping("/api/users")
public class EmployeeController {

   @Autowired
   private EmployeeService userService;

   @PostMapping("/signup")
   public ResponseEntity<EmployeeEntity> signup(@Valid @RequestBody EmployeeEntity user) {
      EmployeeEntity savedUser = userService.signup(user);
      return ResponseEntity.ok(savedUser);
   }

   @PostMapping("/login")
   public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
      String token = userService.login(loginRequest.getEmailId(), loginRequest.getPassword());
      return ResponseEntity.ok(token);
   }
}


