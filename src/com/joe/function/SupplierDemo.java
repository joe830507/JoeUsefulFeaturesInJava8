package com.joe.function;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SupplierDemo {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Grace", "Lilly", "Gina", "Jessie");
		Optional<String> first = names.stream().filter(name -> name.startsWith("A")).findFirst();
		if (first.isPresent())
			System.out.println(first);
		else
			System.out.println(first.orElseGet(
					() -> String.format("Not found in %s", names.stream().collect(Collectors.joining(", ")))));
	}
}
