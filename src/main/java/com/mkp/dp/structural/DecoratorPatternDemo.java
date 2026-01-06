package com.mkp.dp.structural;

/**
 * allows behavior to be added to individual objects, dynamically, without
 * affecting the behavior of other objects from the same class. It provides a
 * flexible alternative to subclassing for extending functionality.
 */
public class DecoratorPatternDemo {
	public static void main(String[] args) {
		Coffee coffee = new SimpleCoffee();
		System.out.println(coffee.getDescription() + " Cost: " + coffee.getCost());

		coffee = new MilkDecorator(coffee);
		System.out.println(coffee.getDescription() + " Cost: " + coffee.getCost());

		coffee = new SugarDecorator(coffee);
		System.out.println(coffee.getDescription() + " Cost: " + coffee.getCost());
	}

}

//Component Interface
interface Coffee {
	String getDescription();

	double getCost();
}

//Concrete Component
class SimpleCoffee implements Coffee {
	@Override
	public String getDescription() {
		return "Simple coffee";
	}

	@Override
	public double getCost() {
		return 5.0;
	}
}

//Base Decorator (Abstract)
abstract class CoffeeDecorator implements Coffee {
	protected Coffee decoratedCoffee;

	public CoffeeDecorator(Coffee coffee) {
		this.decoratedCoffee = coffee;
	}

	public String getDescription() {
		return decoratedCoffee.getDescription();
	}

	public double getCost() {
		return decoratedCoffee.getCost();
	}
}

//Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
	public MilkDecorator(Coffee coffee) {
		super(coffee);
	}

	@Override
	public String getDescription() {
		return decoratedCoffee.getDescription() + ", Milk";
	}

	@Override
	public double getCost() {
		return decoratedCoffee.getCost() + 1.5;
	}
}

class SugarDecorator extends CoffeeDecorator {
	public SugarDecorator(Coffee coffee) {
		super(coffee);
	}

	@Override
	public String getDescription() {
		return decoratedCoffee.getDescription() + ", Sugar";
	}

	@Override
	public double getCost() {
		return decoratedCoffee.getCost() + 0.5;
	}
}
