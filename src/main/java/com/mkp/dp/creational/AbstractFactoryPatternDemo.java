package com.mkp.dp.creational;

/**
 * provides an interface to create families of related or dependent objects
 * without specifying their concrete classes. It is essentially a factory of
 * factories, where a single factory creates multiple products that belong to a
 * related set.
 * 
 */
public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {

		Carfactory indianCarFactory = new IndianCarFactory();
		indianCarFactory.createCar().assemble();
		indianCarFactory.createSpecification().display();

		Carfactory europeCarFactory = new EuropeCarFactory();
		europeCarFactory.createCar().assemble();
		europeCarFactory.createSpecification().display();

	}

}

interface Car {
	void assemble();
}

class Sedan implements Car {
	@Override
	public void assemble() {
		System.out.println("Assembling sedan car");
	}
}

class Suv implements Car {
	@Override
	public void assemble() {
		System.out.println("Assembling suv car");
	}
}

interface CarSpecification {
	void display();
}

class IndianSpecification implements CarSpecification {
	@Override
	public void display() {
		System.out.println("Indian car specification: Safety govern by local rules.");
	}
}

class EuropeSpecification implements CarSpecification {
	@Override
	public void display() {
		System.out.println("Europe car specification: Safety govern by EU standards.");
	}
}

interface Carfactory {
	Car createCar();

	CarSpecification createSpecification();
}

class IndianCarFactory implements Carfactory {
	@Override
	public Car createCar() {
		return new Suv();
	}

	@Override
	public CarSpecification createSpecification() {
		return new IndianSpecification();
	}
}

class EuropeCarFactory implements Carfactory {
	@Override
	public Car createCar() {
		return new Sedan();
	}

	@Override
	public CarSpecification createSpecification() {
		return new EuropeSpecification();
	}
}
