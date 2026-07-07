package com.demo.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.demo.spring.clients.MyFeignClient;

@Component
public class FeignClientRunner implements CommandLineRunner {

	private MyFeignClient myFeignClient;
	
	public FeignClientRunner(MyFeignClient myFeignClient) {
		System.out.println(myFeignClient.getClass().getName());
		this.myFeignClient = myFeignClient;
	}

	@Override
	public void run(String... args) throws Exception {
		
	ResponseEntity<EmpDTO> response=myFeignClient.getEmpData(104);
	System.out.println(response.getBody());
	}

}
