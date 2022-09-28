package com.DesignPatterns.AbstractFactoryMethod;

interface Button{
	public void paint();
}
class WindowsButton implements Button{
	public void paint()
	{
		System.out.println("This is windows button");
	}
	
}
class MacOsButton implements Button{
	public void paint()
	{
		System.out.println("This is MacOS button");
	}
}


interface Checkbox{
	public void paint();
}
class WindowsCheckbox implements Checkbox{
	public void paint()
	{
		System.out.println("This is windows checkbox");
	}
	
}
class MacOsCheckbox implements Checkbox{
	public void paint()
	{
		System.out.println("This is MacOS checkbox");
	}
}

interface GUIFactory{
	public Button createButton();
	public Checkbox createCheckbox();
}
class WindowsFactory implements GUIFactory{

	@Override
	public Button createButton() {
		return new WindowsButton();
	}

	@Override
	public Checkbox createCheckbox() {
		return new WindowsCheckbox();
	}
	
	
}
class MacOsFactory implements GUIFactory{

	@Override
	public Button createButton() {
		return new MacOsButton();
	}

	@Override
	public Checkbox createCheckbox() {
		return new MacOsCheckbox();
	}
	
}
 class Application {
	Button button;
	Checkbox checkbox;
	public Application(GUIFactory guiFactory) {
		button=guiFactory.createButton();
		checkbox=guiFactory.createCheckbox();
	}
	public void paint()
	{
		button.paint();
		checkbox.paint();
		
	}
}
 public class AbstractFactoryMethod{
	public static void main(String[]args)
	{
		String input="MacOs";
		Application AFM;
		GUIFactory guiFactory=null;
		if(input=="windows")
		{
			guiFactory=new WindowsFactory();
			
		}
		else if(input=="MacOs")
		{
			guiFactory=new MacOsFactory();
		}
		AFM=new Application(guiFactory);
		AFM.paint();
	}
}
