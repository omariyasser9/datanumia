package kata.service;

import java.util.HashMap;
import java.util.Map;

import kata.model.Category;
import kata.model.CategoryEnum;
import kata.model.ChanceCategory;
import kata.model.FullHouseCategory;
import kata.model.LargeStraightCategory;
import kata.model.NumberOfAKind;
import kata.model.PairCategory;
import kata.model.SmallStraightCategory;
import kata.model.SumByValueCategory;
import kata.model.TwosPairsCategory;
import kata.model.YatzyCategory;

public class FactoryCategories {

	private static Map<CategoryEnum, Category> categories = new HashMap();

	private static void initializeCategories() {
		categories.put(CategoryEnum.CHANCE, new ChanceCategory());
		categories.put(CategoryEnum.YATZY, new YatzyCategory());
		categories.put(CategoryEnum.ONES, new SumByValueCategory(1));
		categories.put(CategoryEnum.TWOS, new SumByValueCategory(2));
		categories.put(CategoryEnum.THREES, new SumByValueCategory(3));
		categories.put(CategoryEnum.FOURS, new SumByValueCategory(4));
		categories.put(CategoryEnum.FIVES, new SumByValueCategory(5));
		categories.put(CategoryEnum.SIXES, new SumByValueCategory(6));
		categories.put(CategoryEnum.PAIR, new PairCategory());
		categories.put(CategoryEnum.TWO_PAIRS, new TwosPairsCategory());
		categories.put(CategoryEnum.THREE_OF_KIND, new NumberOfAKind(3));
		categories.put(CategoryEnum.FOUR_OF_KIND, new NumberOfAKind(4));
		categories.put(CategoryEnum.SMALL_STRAIGHT, new SmallStraightCategory());
		categories.put(CategoryEnum.LARGE_STRAIGHT, new LargeStraightCategory());
		categories.put(CategoryEnum.FULL_HOUSE, new FullHouseCategory());
	}

	public static Category buildCategory(CategoryEnum category) {
		if (categories.isEmpty()) {
			initializeCategories();
		}
		return categories.get(category);
	}
}
