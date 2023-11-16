package kata.model;

import kata.model.DiceRoll;

public class ChanceCategory implements Category {

	@Override
	public int getScore(DiceRoll diceRoll) {
		return diceRoll.sum();
	}
}