package com.DesignPatterns.Bridge;

public interface NotificationSender {
	void sendNotification();
}

class Email implements NotificationSender
{

	@Override
	public void sendNotification() {
		// TODO Auto-generated method stub
		System.out.println("Via Email");
	}
	
}
class SMS implements NotificationSender{

	@Override
	public void sendNotification() {
		// TODO Auto-generated method stub
		System.out.println("via SMS");
	}
	
}
