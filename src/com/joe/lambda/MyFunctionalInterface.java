package com.joe.lambda;

@FunctionalInterface
public interface MyFunctionalInterface {

	int myMethod();

	default String sayHello() {
		return "Hello, world";
	}

	static void myStaticMethod() {
		System.out.println("This is a functional interface.");
	}
}
