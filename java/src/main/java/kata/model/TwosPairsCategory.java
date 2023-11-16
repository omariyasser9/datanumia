package com.kata.model;

public class TwosPairsCategory implements Category {

	@Override
	public int getScore(DiceRoll diceRoll) {
		if (diceRoll.findPairs().size() >= 2) {
			return diceRoll.findPairs().stream().mapToInt(d -> d * 2).sum();
		}
		return 0;
	}

}
