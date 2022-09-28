package com.DesignPatterns.Command;

interface ElectronicDevice{
	public void on();
	public void off();
	public void volumeUp();
	public void volumeDown();
	
}
class Television implements ElectronicDevice{
	Integer volume=0;
	@Override
	public void on() {
		System.out.println("TV on");
	}

	@Override
	public void off() {
		System.out.println("TV off");		
	}

	@Override
	public void volumeUp() {
		volume++;
		System.out.println("Volume up");
	}

	@Override
	public void volumeDown() {
		volume--;
		System.out.println("Volume down");		
	}
	
}


interface Command{
	public void execute();
	public void undo();
}

class TVon implements Command{
	ElectronicDevice electronicDevice;
	public TVon(ElectronicDevice electronicDevice) {
		super();
		this.electronicDevice = electronicDevice;
	}
	@Override
	public void execute() {
		electronicDevice.on();
	}
	public void undo()
	{
		electronicDevice.off();
	}
	
}
class TVoff implements Command{
	ElectronicDevice electronicDevice;
	public TVoff(ElectronicDevice electronicDevice) {
		super();
		this.electronicDevice = electronicDevice;
	}
	@Override
	public void execute() {
		electronicDevice.off();
	}
	public void undo()
	{
		electronicDevice.on();
	}
	
}
class TVvolumeUp implements Command{
	ElectronicDevice electronicDevice;
	public TVvolumeUp(ElectronicDevice electronicDevice) {
		super();
		this.electronicDevice = electronicDevice;
	}
	@Override
	public void execute() {
		electronicDevice.volumeUp();
	}
	public void undo()
	{
		electronicDevice.volumeDown();
	}
}

class RemoteButton{
	Command command;
	
	public RemoteButton(Command command) {
		super();
		this.command = command;
	}

	public void onPress()
	{
		command.execute();
	}
	
	public void onPressUndo()
	{
		command.undo();
	}
}

class TVRemote{
	public static ElectronicDevice getTV()
	{
		return new Television();
	}
}
public class Test {
	public static void main(String...args)
	{
		ElectronicDevice electronicDevice=TVRemote.getTV();
		Command command=new TVon(electronicDevice);
		RemoteButton remotebutton=new RemoteButton(command);
		remotebutton.onPress();
		remotebutton.onPressUndo();
	}
}
