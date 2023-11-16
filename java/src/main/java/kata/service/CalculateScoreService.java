package com.kata.service;

import java.util.List;

import com.refactoring.kata.model.CategoryEnum;

public interface CalculateScoreService {

	public Integer getScore(CategoryEnum category, List<Integer> dices);

}
