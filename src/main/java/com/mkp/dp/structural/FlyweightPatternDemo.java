package com.mkp.dp.structural;

import java.util.HashMap;

/**
 * used to minimize memory usage or computational expenses by sharing as much
 * data as possible with similar objects.
 */
public class FlyweightPatternDemo {
	private static final String[] colors = { "Red", "Green", "Blue", "Yellow", "Black" };

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			Circle circle = ShapeFactory.getCircle(getRandomColor());
			circle.draw(getRandomX(), getRandomY(), 10);
		}
	}

	private static String getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	private static int getRandomX() {
		return (int) (Math.random() * 100);
	}

	private static int getRandomY() {
		return (int) (Math.random() * 100);
	}
}

//Flyweight interface
interface Shape {
	void draw(int x, int y, int radius);
}

//Concrete Flyweight Class
class Circle implements Shape {
	private String color; // Intrinsic state

	public Circle(String color) {
		this.color = color;
		System.out.println("Creating Circle of color: " + color);
	}

	@Override
	public void draw(int x, int y, int radius) {
		System.out.println("Circle: Draw() [Color: " + color + ", x: " + x + ", y: " + y + ", radius: " + radius + "]");
	}
}

//Flyweight Factory
class ShapeFactory {
	private static final HashMap<String, Circle> circleMap = new HashMap<>();

	public static Circle getCircle(String color) {
		Circle circle = circleMap.get(color);
		if (circle == null) {
			circle = new Circle(color);
			circleMap.put(color, circle);
		}
		return circle;
	}
}
