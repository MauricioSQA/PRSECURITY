package com.isil.demo.jwt.controller.auth;

import com.isil.demo.jwt.jwt.JwtService;
import com.isil.demo.jwt.model.Role;
import com.isil.demo.jwt.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isil.demo.jwt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UserRepository userRepository;
	private final AuthenticationManager authenticationManager;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	public AuthResponse login(LoginRequest request){
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
		String token = jwtService.getToken(user);
		return AuthResponse.builder()
				.token(token)
				.build();
	}

	public AuthResponse register(RegisterRequest request){
		User user = User.builder()
				.username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword()))
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.country(request.getCountry())
				.role(Role.USER)
				.build();

		userRepository.save(user);

		return AuthResponse.builder()
				.token(jwtService.getToken(user))
				.build();
	}

}
