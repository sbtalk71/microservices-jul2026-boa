package com.demo.spring;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient.Builder;

@Service
public class HrService {

	private Builder clientBuilder;

	public HrService(Builder clientBuilder) {
		this.clientBuilder = clientBuilder;
	}

	public EmpDTO findEmp(Integer id) {

		return clientBuilder.build()
				.get().uri("http://emp-service/emp/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve().body(EmpDTO.class);
	}
	
	public String testBalancer() {

		return clientBuilder.build()
				.get().uri("http://emp-service/balancer-test")
				.retrieve().body(String.class);
	}
}
