package com.DesignPatterns.Bridge;

public class QRcode extends Notification{

	public QRcode(NotificationSender notificationSender) {
		super(notificationSender);
		System.out.println("QRcode");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		notificationSender.sendNotification();
	}
	
}
