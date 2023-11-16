package com.kata.model;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DiceRoll {

	List<Integer> dices;

	public DiceRoll(List<Integer> dices) {
		this.dices = dices;
	}

	public List<Integer> getDices() {
		return dices;
	}

	public void setDices(List<Integer> dices) {
		this.dices = dices;
	}

	public Map<Integer, Integer> getCountsByDice() {
		return dices.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(x -> 1)));
	}

	public boolean isYatzy() {
		return getCountsByDice().values().stream().anyMatch(c -> c == 5);
	}

	public List<Integer> getCountsByDiceGreaterThan(int n) {
		return getCountsByDice().entrySet().stream().filter(entry -> entry.getValue() >= n).map(Entry::getKey)
				.collect(Collectors.toList());
	}

	public List<Integer> findPairs() {
		return getCountsByDiceGreaterThan(2).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}

	public boolean isSmallStraight() {
		return dices.stream().sorted().collect(Collectors.toList()).equals(List.of(1, 2, 3, 4, 5));
	}

	public boolean isLargeStraight() {
		return dices.stream().sorted().collect(Collectors.toList()).equals(List.of(2, 3, 4, 5, 6));
	}

	public boolean hasThreeOfAKind() {
		return getCountsByDiceGreaterThan(3).stream().findAny().orElse(0) != 0;
	}

	public boolean hasAPair() {
		return getCountsByDiceGreaterThan(2).stream().findAny().orElse(0) != 0;

	}

	public boolean isFullHouse() {
		return hasThreeOfAKind() && hasAPair() && !isYatzy();
	}

	public int sum() {
		return dices.stream().mapToInt(Integer::intValue).sum();
	}
}
