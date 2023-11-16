package com.kata.service;

import java.util.List;
import java.util.Optional;

import com.refactoring.kata.model.Category;
import com.refactoring.kata.model.CategoryEnum;
import com.refactoring.kata.model.DiceRoll;

public class CalculateScoreServiceImpl implements CalculateScoreService {

	@Override
	public Integer getScore(CategoryEnum categoryName, List<Integer> dices) {
		Optional<Category> category = Optional.ofNullable(FactoryCategories.buildCategory(categoryName));
		if (category.isPresent()) {
			return category.get().getScore(new DiceRoll(dices));
		}
		return null;
	}

}
