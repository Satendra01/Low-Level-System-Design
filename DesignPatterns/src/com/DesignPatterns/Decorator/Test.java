package com.DesignPatterns.Decorator;

interface Pizza{
	public String getDescription();
	public Double getCost();
	
}

class ThreeCheesePizza implements Pizza{
	
	@Override
	public String getDescription() {
		return "ThreeCheesePizza";
	}

	@Override
	public Double getCost() {
		return 25.0;
	}
	
}
class BasicPizza implements Pizza{

	@Override
	public String getDescription() {
		return "BasicPizza";
	}

	@Override
	public Double getCost() {
		return 10.0;
	}
	
}
class ToppingDecorator implements Pizza{
	Pizza pizza;

	public ToppingDecorator(Pizza pizza) {
		super();
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		return pizza.getDescription();
	}

	@Override
	public Double getCost() {
		return pizza.getCost();
	}
	
}
class ToppingOne extends ToppingDecorator{

	public ToppingOne(Pizza pizza) {
		super(pizza);
		System.out.println("Adding topping one");
		
	}
	public String getDescription()
	{
		return pizza.getDescription()+ " Topping one added";
	}
	public Double getCost() {
		return pizza.getCost()+5.00;
 	}
	
}
class ToppingTwo extends ToppingDecorator{

	public ToppingTwo(Pizza pizza) {
		super(pizza);
		System.out.println("Adding topping Two");
		
	}
	public String getDescription()
	{
		return pizza.getDescription()+ " Topping Two added";
	}
	public Double getCost() {
		return pizza.getCost()+10.00;
 	}
	
}
public class Test {
	public static void main(String...args)
	{
		Pizza pizza=new ToppingTwo(new ToppingOne(new BasicPizza()));
		System.out.println(pizza.getDescription());
		System.out.println(pizza.getCost());
	}

}
