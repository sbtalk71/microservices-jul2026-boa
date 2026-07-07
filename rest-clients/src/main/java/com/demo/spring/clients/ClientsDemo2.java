package com.demo.spring.clients;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import com.demo.spring.EmpDTO;

public class ClientsDemo2 {

	public static void main(String[] args) {
		
		RestClient restClient=RestClient.create();
		
		ResponseEntity<EmpDTO> responseEntity=restClient.get()
				.uri("http://localhost:8181/emp/104")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.toEntity(EmpDTO.class);
		System.out.println(responseEntity.getBody());
		
		EmpDTO empDto=restClient.get()
				.uri("http://localhost:8181/emp/104")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(EmpDTO.class);
		
		System.out.println(empDto);
		
		
		EmpDTO postData=new EmpDTO("Ranga","Hyderabad", 78000.0);
		
		EmpDTO empData=restClient.post()
				.uri("http://localhost:8181/emp")
				.body(postData)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(EmpDTO.class);
		
		System.out.println(empData);
		
		
		List<EmpDTO> empList=restClient.get()
				.uri("http://localhost:8181/emp")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(new ParameterizedTypeReference<List<EmpDTO>>() {
				});
		
		empList.stream().forEach(System.out::println);
		

	}

}
