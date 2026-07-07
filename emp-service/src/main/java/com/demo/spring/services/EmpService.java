package com.demo.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.spring.EmpRepository;
import com.demo.spring.entities.Emp;
import com.demo.spring.exceptions.EmpNotFoundException;

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
			throw new EmpNotFoundException("Emp Not Found..");
		}
		
		//return empRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	public List<Emp> getAll(){
		return empRepository.findAll();
	}
	
	
	public Emp saveEmp(Emp e) {
		return empRepository.save(e);
	}
	
}
