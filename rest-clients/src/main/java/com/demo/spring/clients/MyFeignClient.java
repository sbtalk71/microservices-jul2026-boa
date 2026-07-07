package com.demo.spring.clients;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.spring.EmpDTO;

@FeignClient(url = "http://localhost:8181/emp",name="client3")
public interface MyFeignClient {

	@GetMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpDTO> getEmpData(@PathVariable Integer id);
}
