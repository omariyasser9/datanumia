package kata.service;

import java.util.List;

import kata.model.CategoryEnum;

public interface CalculateScoreService {

	public Integer getScore(CategoryEnum category, List<Integer> dices);

}
