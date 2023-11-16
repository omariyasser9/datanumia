package com.kata.model;

public class PairCategory implements Category {

	@Override
	public int getScore(DiceRoll diceRoll) {
		if (diceRoll.findPairs().isEmpty()) {
			return 0;
		} else {
			return diceRoll.findPairs().get(0) * 2;
		}
	}

}
