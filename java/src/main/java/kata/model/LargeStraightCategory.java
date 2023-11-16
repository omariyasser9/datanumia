package com.kata.model;

public class LargeStraightCategory implements Category {

	@Override
	public int getScore(DiceRoll diceRoll) {
		if (diceRoll.isLargeStraight()) {
			return 20;
		}
		return 0;
	}

}
