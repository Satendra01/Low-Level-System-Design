package com.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

interface Subject{
	 public void register(Observer o);
	 public void Unregister(Observer o);
	 public void notifyObserver();
}

interface Observer{
	public void update(double ibmprice,double googprice,double appprice);
}

class StockGrabber implements Subject{
	List<Observer>observers;
	double ibmprice,googprice,appprice;
	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

	public void setIbmprice(double ibmprice) {
		this.ibmprice = ibmprice;
		notifyObserver();
	}

	public void setGoogprice(double googprice) {
		this.googprice = googprice;
		notifyObserver();
	}

	public void setAppprice(double appprice) {
		this.appprice = appprice;
		notifyObserver();
	}

	public StockGrabber() {
		super();
		this.observers = new ArrayList<>();
	}

	@Override
	public void register(Observer o) {
		observers.add(o);
	}

	@Override
	public void Unregister(Observer o) {
		int index=observers.indexOf(o);
		observers.remove(index);
		System.out.println("Observer "+ index+" deleted" );
	}

	@Override
	public void notifyObserver() {
		for(Observer o:observers)
		o.update(ibmprice, googprice, appprice);
	}
	
}

class StockObserver implements Observer{
	double ibmprice,googprice,appprice;
	static int observerIDtracker=0;
	int observerID;
	Subject stockGrabber;
	StockObserver(StockGrabber stockGrabber)
	{
		this.observerID=observerIDtracker++;
		this.stockGrabber =stockGrabber;
		System.out.println("new observer "+observerID);
		stockGrabber.register(this);
	}
	@Override
	public void update(double ibmprice, double googprice, double appprice) {
		this.ibmprice=ibmprice;
		this.googprice=googprice;
		this.appprice=appprice;
		printThePrices();
	}
	public void printThePrices()
	{
		System.out.println("ibmprice : "+ibmprice+"\n googprice : "+googprice+ "\nappprice : "+appprice);
	}
	
	
}


public class Test {
	public static void main(String...args)
	{
		// Create the Subject object
				// It will handle updating all observers 
				// as well as deleting and adding them
				
				StockGrabber stockGrabber = new StockGrabber();
				
				// Create an Observer that will be sent updates from Subject
				
				StockObserver observer1 = new StockObserver(stockGrabber);
				
				stockGrabber.setIbmprice(197.00);
				stockGrabber.setAppprice(677.60);
				stockGrabber.setGoogprice(676.40);
				
				StockObserver observer2 = new StockObserver(stockGrabber);
				
				stockGrabber.setIbmprice(195.00);
				stockGrabber.setAppprice(673.60);
				stockGrabber.setGoogprice(677.40);
				
				// Delete one of the observers
				
				// stockGrabber.unregister(observer2);
				
				stockGrabber.setIbmprice(197.00);
				stockGrabber.setAppprice(677.60);
				stockGrabber.setGoogprice(676.40);
				
	}
}
