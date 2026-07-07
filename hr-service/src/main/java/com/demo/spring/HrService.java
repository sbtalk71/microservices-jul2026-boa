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
				.get().uri("http://localhost:8181/emp/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve().body(EmpDTO.class);
	}
}
