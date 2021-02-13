package com.joe.lambda;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LambdaDemo {

	public static void main(String[] args) {
		demoRunnable();
		demoSystemOutPrinln();
		demoFilenameFilter();
		demoMathRandomNums();
	}

	private static void demoFilenameFilter() {
		File directory = new File("./src/com/joe/lambda");
		String[] names = directory.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		names = directory.list((File dir, String name) -> name.endsWith(".java"));
		Arrays.asList(names).forEach(System.out::println);
	}

	private static void demoRunnable() {
		// original
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("anonymous runnable1");
			}
		}).start();
		// way1
		new Thread(() -> System.out.println("anonymous runnable2")).start();
		// way2
		Runnable r = () -> System.out.println("anonymous runnable3");
		new Thread(r).start();
	}

	private static void demoSystemOutPrinln() {
		List<String> nums = Arrays.asList(new String[] { "1", "2", "3" });
		nums.forEach(System.out::println);
		Consumer<String> consumer = System.out::println;
		nums.forEach(consumer);
	}

	private static void demoMathRandomNums() {
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
	}
}
