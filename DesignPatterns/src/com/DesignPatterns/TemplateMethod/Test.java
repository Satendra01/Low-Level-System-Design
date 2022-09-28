package com.DesignPatterns.TemplateMethod;


//A Template Method Pattern contains a method that provides
//the steps of the algorithm. It allows subclasses to override 
//some of the methods

 abstract class Sandwich {
	
	
	
	// This is the Template Method
	// Declare this method final to keep subclasses from
	// changing the algorithm
	
	final void makeSandwich(){
		
		cutBun();
		
		if(customerWantsMeat()){
			addMeat();
		}
		
		if(customerWantsCheese()){
			addCheese();
		}
		
		if(customerWantsVegetables()){
			addVegetables();
		}
		
		if(customerWantsCondiments()){
			addCondiments();
		}
		
		wrapTheSandwich();
		
	}
	
	// These methods must be overridden by the extending subclasses
	
	abstract void addMeat();
	abstract void addCheese();
	abstract void addVegetables();
	abstract void addCondiments();
	
	public void cutBun(){
		
		System.out.println("The Bun is Cut");
		
	}
	
	// These are called hooks
	// If the user wants to override these they can
	
	// Use abstract methods when you want to force the user
	// to override and use a hook when you want it to be optional
	
	boolean customerWantsMeat() { return true; }
	boolean customerWantsCheese() { return true; }
	boolean customerWantsVegetables() { return true; }
	boolean customerWantsCondiments() { return true; }
	
	public void wrapTheSandwich(){
		
		System.out.println("\nWrap the Sandwich");
		
	}
	
	
	
}
  class ItalianSandwich extends Sandwich{
		
		
		
		public void addMeat(){
			
			System.out.print("Adding the Meat: ");
			
		
		}
		
		public void addCheese(){
			
			System.out.print("Adding the Cheese: ");
		
			
		}
		
		public void addVegetables(){
			
			System.out.print("Adding the Vegetables: ");
			
			
		}
		
		public void addCondiments(){
			
			System.out.print("Adding the Condiments: ");
		
		}
		
	}
  
   class VeggieSandwich extends Sandwich{

		
		
		boolean customerWantsMeat() { return false; }
		boolean customerWantsCheese() { return false; }
		
		public void addVegetables(){
			
			System.out.print("Adding the Vegetables: ");
			
			
			
		}
		
		public void addCondiments(){
			
			System.out.print("Adding the Condiments: ");
			
			
			
		}

		void addMeat() {}
		
		void addCheese() {}
		
		
	}
   
   
   public class Test {
		
		public static void main(String[] args){
			
			ItalianSandwich cust12Hoagie = new ItalianSandwich();
			
			cust12Hoagie.makeSandwich();
			
			System.out.println();
			
			VeggieSandwich cust13Hoagie = new VeggieSandwich();
			
			cust13Hoagie.makeSandwich();
			
		}
		
	}
