package com.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationService implements NotificationService {

	@Override
	public void notifyChannel() {
		System.out.println("Notification sent through Email");
		
	}

}
