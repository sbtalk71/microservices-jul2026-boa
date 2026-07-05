package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.CustomerApp;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		CustomerApp cp=(CustomerApp)context.getBean("customerApp");
		
		cp.sendNotification();

	}

}
