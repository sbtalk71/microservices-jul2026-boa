package com.demo.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

	private final CustomerApp customerApp;

	public AppRunner(CustomerApp customerApp) {
		this.customerApp = customerApp;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		customerApp.sendNotification();
	}

}
