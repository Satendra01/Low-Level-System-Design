package com.DesignPatterns.ChainOfResponsibility;

interface Chain{
	public Chain setNextChain(Chain nextChain);
	public void calculate(Numbers request);
}

class Numbers{
	private int firstNumber,secondNumber;
	
	private String calculationWanted;
	public Numbers(int firstNumber, int secondNumber,String calculationWanted) {
		super();
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.calculationWanted=calculationWanted;
	}
	public int getFirstNumber() {
		return firstNumber;
	}
	public int getSecondNumber() {
		return secondNumber;
	}
	public String getCalculationWanted() {
		return calculationWanted;
	}
	
}

class AddNumbers implements Chain{
	Chain nextInChain;
	@Override
	public Chain setNextChain(Chain nextChain) {
		this.nextInChain=nextChain;
		return nextInChain;
	}

	@Override
	public void calculate(Numbers request) {
		if(request.getCalculationWanted()=="add")
		System.out.println("a+b = "+ request.getFirstNumber()+request.getSecondNumber());
		else
			nextInChain.calculate(request);
	}
	
}

class SubtractNumbers implements Chain{
	Chain nextInChain;
	@Override
	public Chain setNextChain(Chain nextChain) {
		this.nextInChain=nextChain;
		return nextInChain;
	}

	@Override
	public void calculate(Numbers request) {
		if(request.getCalculationWanted().equals("sub"))
		System.out.println("a-b = "+ (request.getFirstNumber()-request.getSecondNumber()));
		else
			nextInChain.calculate(request);
	}
	
}
class MulNumbers implements Chain{
	Chain nextInChain;
	@Override
	public Chain setNextChain(Chain nextChain) {
		this.nextInChain=nextChain;
		return nextInChain;
	}

	@Override
	public void calculate(Numbers request) {
		if(request.getCalculationWanted()=="mul")
		System.out.println("a*b = "+ request.getFirstNumber()*request.getSecondNumber());
		else {
			System.out.println("Only +,-,* allowed");
		}
	}
	
}
public class Test {
	public static void main(String...args)
	{
		Chain chain1=new AddNumbers();
		Chain chain2=new SubtractNumbers();
		Chain chain3=new MulNumbers();
		chain1.setNextChain(chain2).setNextChain(chain3);
		chain1.calculate(new Numbers(4,5,"sub"));
	}
}
