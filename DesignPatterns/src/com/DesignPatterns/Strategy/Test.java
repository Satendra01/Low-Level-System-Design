package com.DesignPatterns.Strategy;

interface Pay{
	double getPay(double Salary);
}
class NoBonus implements Pay{
	
	public double getPay(double salary)
	{
		return salary;
	}
}
class Bonus implements Pay{
	public double getPay(double salary)
	{
		return salary+0.2*salary;
	}
}
class Employee{
	double salary=0.0;
	Pay pay=new NoBonus();
	Employee(double salary)
	{
		this.salary=salary;
	}
	public Employee(double salary, Pay pay) {
		super();
		this.salary = salary;
		this.pay = pay;
	}
	public void setBonusOption(Pay pay)
	{
		this.pay=pay;
	}
	public double getPay()
	{
		return pay.getPay(salary);
	}
	
}
class Salesman extends Employee
{
	Salesman(double salary){
	  super( salary);
	}
	Salesman(double salary,Pay pay)
	{
		super(salary);
		setBonusOption(pay);
	}
	
}
class Secretary extends Employee
{
	Secretary(double salary){
	  super( salary);
	}
	Secretary(double salary,Pay pay)
	{
		super(salary);
		setBonusOption(pay);
	}
	
}
public class Test {
	public static void main(String...args)
	{
		Employee salesman=new Salesman(15000);
		Employee secretary=new Secretary(15000,new Bonus());
		System.out.println("salary of Salesman"+salesman.getPay());
		System.out.println("salary of Secretary"+secretary.getPay());
	}
	
}
