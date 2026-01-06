package com.mkp.dp.creational;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonPatternDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// serialize
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
			SingletonClass instance = SingletonClass.getInstance();
			System.out.println(instance.hashCode());
			oos.writeObject(instance);
		}

		// de-serialize
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {
			SingletonClass copy = (SingletonClass) ois.readObject();
			System.out.println(copy.hashCode());
		}
	}
}

class SingletonClass implements Serializable, Cloneable {
	private static final long serialVersionUID = -5347677144921011116L;

	private static volatile SingletonClass instance;

	private SingletonClass() {
		if (instance != null) {
			throw new IllegalStateException("Instance already exist!!");
		}
	}

	public static SingletonClass getInstance() {
		if (instance == null) {
			System.out.println("calling while instantiation..");
			synchronized (SingletonClass.class) {
				if (instance == null) {
					instance = new SingletonClass();
				}
			}
		}
		return instance;
	}

	public Object readResolve() {
		System.out.println("calling while deserialization..");
		return getInstance();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		System.out.println("calling while cloneing..");
		throw new CloneNotSupportedException("Cloning not allowed for SingletonPattern class");
	}

}
