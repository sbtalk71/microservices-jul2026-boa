package com.demo.spring.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.spring.EmpRepository;
import com.demo.spring.entities.Emp;

@Service
public class EmpService {

	private EmpRepository empRepository;

	public EmpService(EmpRepository empRepository) {
		this.empRepository = empRepository;
	}
	
	
	public Emp findOneEmp(Integer id) {
		Optional<Emp> empOp= empRepository.findById(id);
		
		if(empOp.isPresent()) {
			return empOp.get();
		}else {
			throw new RuntimeException("Emp Not Found..");
		}
		
		//return empRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	
}
