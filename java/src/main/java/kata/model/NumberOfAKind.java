package kata.model;

public class NumberOfAKind implements Category {

	private Integer dice;

	public NumberOfAKind(Integer dice) {
		this.dice = dice;
	}

	@Override
	public int getScore(DiceRoll diceRoll) {
		return diceRoll.getCountsByDiceGreaterThan(dice).stream().findAny().orElse(0) * dice;
	}

}
