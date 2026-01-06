package com.mkp.dp.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * The Visitor Pattern allows you to define new operations on a set of objects
 * without changing their classes. This is especially useful when you need to
 * perform operations on complex object structures, such as trees or
 * hierarchies.
 */
public class VisitorPatternDemo {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Book(20.0));
		cart.addItem(new Electronics(100.0));
		cart.addItem(new Grocery(5.0));
		double total = cart.calculateTotal();
		System.out.println("Total: Rs." + total);
	}
}

//Element Interface
interface Item {
	void accept(ItemVisitor visitor);
}

//Concrete Elements
class Book implements Item {
	private double price;

	public Book(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void accept(ItemVisitor visitor) {
		visitor.visit(this);
	}
}

class Electronics implements Item {
	private double price;

	public Electronics(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void accept(ItemVisitor visitor) {
		visitor.visit(this);
	}
}

class Grocery implements Item {
	private double price;

	public Grocery(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void accept(ItemVisitor visitor) {
		visitor.visit(this);
	}
}

//Visitor Interface
interface ItemVisitor {
	void visit(Book book);

	void visit(Electronics electronics);

	void visit(Grocery grocery);
}

//Concrete Visitors
class ShoppingCartVisitor implements ItemVisitor {
	private double total = 0;

	public void visit(Book book) {
		total += book.getPrice();
	}

	public void visit(Electronics electronics) {
		total += electronics.getPrice() * 1.1; // Adding tax
	}

	public void visit(Grocery grocery) {
		total += grocery.getPrice() * 0.9; // Applying discount
	}

	public double getTotal() {
		return total;
	}
}

//Context
class ShoppingCart {
	private List<Item> items = new ArrayList<>();

	public void addItem(Item item) {
		items.add(item);
	}

	public double calculateTotal() {
		ShoppingCartVisitor visitor = new ShoppingCartVisitor();
		for (Item item : items) {
			item.accept(visitor);
		}
		return visitor.getTotal();
	}
}
