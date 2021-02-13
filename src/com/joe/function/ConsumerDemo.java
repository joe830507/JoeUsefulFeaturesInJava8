package com.joe.function;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		systemOutPrintln();
	}

	private static void systemOutPrintln() {
		Consumer<String> consumer = System.out::println;
		Arrays.asList("Grace", "Lilly", "Gina", "Jessie").stream().forEach(consumer);
	}
}
