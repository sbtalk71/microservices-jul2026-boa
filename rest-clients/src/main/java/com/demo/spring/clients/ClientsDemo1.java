package com.demo.spring.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.EmpDTO;

public class ClientsDemo1 {

	public static void main(String[] args) {
		
		RestTemplate restTemplate=new RestTemplate();
		
		ResponseEntity<String> responseEntity= restTemplate.getForEntity("http://localhost:8181/emp/104", String.class);

		System.out.println(responseEntity.getBody());
		
		ResponseEntity<EmpDTO> responseEntity2= restTemplate.getForEntity("http://localhost:8181/emp/104", EmpDTO.class);

		System.out.println(responseEntity2.getBody());
		
		
	}

}
