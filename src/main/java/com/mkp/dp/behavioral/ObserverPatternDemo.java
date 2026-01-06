package com.mkp.dp.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * The Observer Pattern establishes a one-to-many dependency between objects,
 * ensuring that when one object (the Subject) changes state, all its associated
 * Observers are automatically notified and updated
 */
public class ObserverPatternDemo {
	public static void main(String[] args) {
		StockMarket stockMarket = new StockMarket();

		Observer investor1 = new Investor("Bhanu");
		Observer investor2 = new Investor("Kumar");

		stockMarket.addObserver(investor1);
		stockMarket.addObserver(investor2);

		stockMarket.setPrice(150.0);
		stockMarket.setPrice(160.0);
	}
}

interface Observer {
	void update(String stock, double price);
}

class Investor implements Observer {
	private String name;

	public Investor(String name) {
		this.name = name;
	}

	@Override
	public void update(String stock, double price) {
		System.out.println(name + " notified. New price of " + stock + ": Rs." + price);
	}
}

interface Subject {
	void addObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObservers();
}

class StockMarket implements Subject {
	private List<Observer> observers = new ArrayList<>();
	private double stockPrice;

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update("Tata Power", stockPrice);
		}
	}

	public void setPrice(double price) {
		this.stockPrice = price;
		notifyObservers();
	}
}