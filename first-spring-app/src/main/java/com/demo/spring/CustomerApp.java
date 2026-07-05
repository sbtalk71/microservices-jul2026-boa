package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomerApp {

	
	private NotificationService emailNotification;
	
	private NotificationService notificationService;
	
	//@Autowired
	public CustomerApp( @Qualifier("SMSNotificationService") NotificationService notificationService) {
			this.notificationService = notificationService;
	}




	public void sendNotification() {
		notificationService.notifyChannel();
	}
}
