package kata.model;

public class SmallStraightCategory implements Category {

	@Override
	public int getScore(DiceRoll diceRoll) {
		if (diceRoll.isSmallStraight()) {
			return 15;
		}
		return 0;
	}

}
