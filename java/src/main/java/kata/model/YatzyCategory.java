package kata.model;

public class YatzyCategory implements Category {

	@Override
	public int getScore(DiceRoll diceRoll) {
		if (diceRoll.isYatzy()) {
			return 50;
		}
		return 0;
	}

}
