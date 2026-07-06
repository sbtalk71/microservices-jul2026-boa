package com.demo.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@GetMapping(path = "greet/{name}")
	//http://localhost:8181/greet/Marc?country=Germany
	public String greet(@PathVariable("name") String name,
			@RequestParam(name="country", required = true) String country) {
		return  name+" from "+country+" ,Greetings from Spring";
	}
}
