package com.DesignPatterns.Bridge;

public class Text extends Notification{

	public Text(NotificationSender notificationSender) {
		super(notificationSender);
		System.out.println("text");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		notificationSender.sendNotification();
	}
	

}
