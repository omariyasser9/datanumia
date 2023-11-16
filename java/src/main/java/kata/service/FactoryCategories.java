package com.kata.service;

import java.util.HashMap;
import java.util.Map;

import com.refactoring.kata.model.Category;
import com.refactoring.kata.model.CategoryEnum;
import com.refactoring.kata.model.ChanceCategory;
import com.refactoring.kata.model.FullHouseCategory;
import com.refactoring.kata.model.LargeStraightCategory;
import com.refactoring.kata.model.NumberOfAKind;
import com.refactoring.kata.model.PairCategory;
import com.refactoring.kata.model.SmallStraightCategory;
import com.refactoring.kata.model.SumByValueCategory;
import com.refactoring.kata.model.TwosPairsCategory;
import com.refactoring.kata.model.YatzyCategory;

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
