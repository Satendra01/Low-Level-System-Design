package com.DesignPatterns.Bridge;

public class BridgeMain {
	public static void main(String[]args)
	{
		Notification notification=new QRcode(new Email());
		notification.sendMessage();
	}
}
