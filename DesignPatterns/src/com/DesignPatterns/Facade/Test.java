package com.DesignPatterns.Facade;

class WelcomeToBank{
	WelcomeToBank()
	{
		System.out.println("Welcome to ABC bank");
	}
}
class AccountNumberCheck{
	private int accountNo=12345;

	public AccountNumberCheck(int accountNo) {
		super();
		this.accountNo = accountNo;
	}

	public int getAccountNo() {
		return accountNo;
	}
	
}

class SecurityCodeCheck{
	private int securityCode=123;

	public SecurityCodeCheck(int securityCode) {
		super();
		this.securityCode = securityCode;
	}

	public int getSecurityCode() {
		return securityCode;
	}
	
}
class FundsCheck{
	private double accountBalance=100;
	public double getAccountBalance()
	{
		return accountBalance;
		
	}
	public void increaseBalance(double amount)
	{
		accountBalance+=amount;
		System.out.println("Current Balance "+ accountBalance);
	}
	public void decreaseBalance(double amt)
	{
		accountBalance-=amt;
		System.out.println("Current Balance "+ accountBalance);
	}
	public boolean haveEnoughMoney(double amt)
	{
		if(amt>accountBalance)
		{
			System.out.println("Insufficient Funds");
			return false;
		}
		
		return true;
	}
	
}
class BankAccountFacade{
	private int accountNo;
	private int securityCode;
	private WelcomeToBank bank;
	private AccountNumberCheck acc;
	private SecurityCodeCheck sec;
	private FundsCheck fundsCheck;
	public BankAccountFacade(int accountNo, int securityCode) {
		super();
		this.accountNo = accountNo;
		this.securityCode = securityCode;
		bank=new WelcomeToBank();
		acc=new AccountNumberCheck(accountNo);
		sec=new SecurityCodeCheck(securityCode);
		fundsCheck= new FundsCheck();
	}
	
	public void withdraw(double amt)
	{
		if(acc.getAccountNo()==accountNo && sec.getSecurityCode()==securityCode && fundsCheck.haveEnoughMoney(amt)==true)
			fundsCheck.decreaseBalance(amt);
		else
			System.out.println("Transaction declined");
	}
	public void deposit(double amt)
	{
		if(acc.getAccountNo()==accountNo && sec.getSecurityCode()==securityCode)
			fundsCheck.increaseBalance(amt);
		else
			System.out.println("Transaction declined");
	}
}
public class Test {
	public static void main(String...args)
	{
		BankAccountFacade baf = new BankAccountFacade(123,12345);
		baf.withdraw(10);
		baf.deposit(100);
	}
	
}
