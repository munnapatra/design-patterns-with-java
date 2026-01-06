package com.practise;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		char[] password = {'s','e','c','r','e','t'};
		Arrays.fill(password, '\0');
		System.out.println(password);
		
		Parent p = new Child();
		p.ABC();

	}
}

class Parent {
     void ABC() {
        System.out.println("Parent ABC");
    }
}

class Child extends Parent {
     void ABC() {
        System.out.println("Child ABC");
    }
}