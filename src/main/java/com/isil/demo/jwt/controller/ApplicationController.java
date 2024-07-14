package com.isil.demo.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApplicationController {

	@GetMapping(value ="demo")
	public String welcome() {
		return "Welcome";
	}
	
}
