package com.kata.yatzy;

import static java.util.stream.Collectors.reducing;

import java.util.List;
import java.util.stream.Collector;

public class YatzyApplication {

	public static final Collector<Integer, ?, Integer> countingInt = reducing(0, e -> 1, Integer::sum);

	public static void main(String[] args) {
		int a = List.of(1, 2, 3, 4, 4).stream().collect(countingInt);

		System.out.println("Hello World");
	}

}
