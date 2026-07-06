package com.demo.spring.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpRepository;
import com.demo.spring.entities.Emp;

@RestController
@RequestMapping("/emp")
public class EmpRestController {

	private EmpRepository empRepository;
	
	
	public EmpRestController(EmpRepository empRepository) {
		this.empRepository = empRepository;
	}


	@GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Emp> findOneEmp() {
		System.out.println("Repo Class : "+empRepository.getClass().getName());
		return empRepository.findAll();
	}
}
