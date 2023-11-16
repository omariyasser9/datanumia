package com.kata.model;

public class SumByValueCategory implements Category {

	private Integer dice;

	public SumByValueCategory(Integer dice) {
		this.dice = dice;
	}

	@Override
	public int getScore(DiceRoll diceRoll) {
		return diceRoll.getCountsByDice().getOrDefault(dice, 0) * dice;
	}

}
