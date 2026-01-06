package com.mkp.dp.creational;

/**
 * defines an interface for creating objects, but allows subclasses to decide
 * which class to instantiate. This pattern helps encapsulate object creation,
 * promoting loose coupling by delegating the instantiation process to
 * subclasses rather than hard coding it.
 */
public class FactoryMethodPatternDemo {
	public static void main(String[] args) {
		Client client = new Client(new FourWheelerVehicleFactory());
		client.getVehicle().printVehicle();

		Client client1 = new Client(new TwoWheelerVehicleFactory());
		client1.getVehicle().printVehicle();
	}

}

//Product Interface
interface Vehicle {
	void printVehicle();
}

//Concrete Products
class TwoWheelerVehicle implements Vehicle {
	@Override
	public void printVehicle() {
		System.out.println("I am two wheeler vehicle");
	}
}

class FourWheelerVehicle implements Vehicle {
	@Override
	public void printVehicle() {
		System.out.println("I am four wheeler vehicle");
	}
}

//Creator (Factory)
interface VehicleFactory {
	Vehicle createVehicle();
}

//Concrete Creators
class TwoWheelerVehicleFactory implements VehicleFactory {
	@Override
	public Vehicle createVehicle() {
		return new TwoWheelerVehicle();
	}
}

class FourWheelerVehicleFactory implements VehicleFactory {
	@Override
	public Vehicle createVehicle() {
		return new FourWheelerVehicle();
	}
}

class Client {
	Vehicle vehicle;

	public Client(VehicleFactory factory) {
		this.vehicle = factory.createVehicle();
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
}