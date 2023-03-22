package com.hashigo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hashigo.Entity.EmployeeEntity;
import com.hashigo.Jwt.JwtTokenProvider;
import com.hashigo.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	public EmployeeEntity signup(EmployeeEntity user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public String login(String emailId, String password) {

		Optional<EmployeeEntity> optionalUser = userRepository.findByEmailId(emailId);
		EmployeeEntity user = optionalUser
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + emailId));

		if (!passwordEncoder.matches(password, user.getPassword())) {
			throw new BadCredentialsException("Invalid username/password");
		}

		List<String> roles = new ArrayList<>();
		roles.add(user.getRole());

		return jwtTokenProvider.createToken(user.getEmailId(), roles);

	}

}
