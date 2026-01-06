package com.mkp.dp.creational;

/**
 * separates the construction of a complex object from its representation,
 * allowing you to create different representations using the same construction
 * process. It focuses on building an object step by step, providing greater
 * control over the construction process.
 * 
 * 
| Feature    | Builder Pattern                                    | Factory Method                                 |
| ---------- | -------------------------------------------------- | ---------------------------------------------- |
| Purpose    | Step-wise construction of complex objects          | Creating object instances                      |
| Complexity | Handles intricate construction with several steps  | Handles simpler object creation                |
| Result     | Builds complex object with detailed configuration  | Returns single product instance                |
| Use Case   | Suitable for objects needing stepwise construction | Suitable when exact class instantiation varies |
 */
public class BuilderPatternDemo {
	public static void main(String[] args) {
		House house = new HouseBuilder()
				.buildFoundation("Concrete")
				.buildStructure("Wood")
				.buildRoof("Steel").build();
		System.out.println(house);
	}
}

class House {
    private String foundation;
    private String structure;
    private String roof;

    public House(String foundation, String structure, String roof) {
        this.foundation = foundation;
        this.structure = structure;
        this.roof = roof;
    }

    public String toString() {
        return "House with " + foundation + ", " + structure + ", and " + roof;
    }
}

class HouseBuilder {
    private String foundation;
    private String structure;
    private String roof;

    public HouseBuilder buildFoundation(String foundation) {
        this.foundation = foundation;
        return this;
    }

    public HouseBuilder buildStructure(String structure) {
        this.structure = structure;
        return this;
    }

    public HouseBuilder buildRoof(String roof) {
        this.roof = roof;
        return this;
    }

    public House build() {
        return new House(foundation, structure, roof);
    }
}
