package com.kata.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.refactoring.kata.model.CategoryEnum;

public class YatzyTest {

    public CalculateScoreService calculateScoreService = new CalculateScoreServiceImpl();

    @Test
    public void testChance() {
        assertEquals(15, calculateScoreService.getScore(CategoryEnum.CHANCE, List.of(2, 3, 4, 5, 1)));
        assertEquals(16, calculateScoreService.getScore(CategoryEnum.CHANCE, List.of(3, 3, 4, 5, 1)));
    }

    @Test
    public void testYatzy() {
        assertEquals(50, calculateScoreService.getScore(CategoryEnum.YATZY, List.of(4, 4, 4, 4, 4)));
        assertEquals(50, calculateScoreService.getScore(CategoryEnum.YATZY, List.of(6, 6, 6, 6, 6)));
        assertEquals(0, calculateScoreService.getScore(CategoryEnum.YATZY, List.of(6, 6, 6, 6, 3)));

    }

    @Test
    public void testOnes() {
        assertEquals(1, calculateScoreService.getScore(CategoryEnum.ONES, List.of(1, 2, 3, 4, 5)));
        assertEquals(2, calculateScoreService.getScore(CategoryEnum.ONES, List.of(1, 2, 1, 4, 5)));
        assertEquals(0, calculateScoreService.getScore(CategoryEnum.ONES, List.of(6, 2, 2, 4, 5)));
        assertEquals(4, calculateScoreService.getScore(CategoryEnum.ONES, List.of(1, 2, 1, 1, 1)));

    }

    @Test
    public void testTwos() {
        assertEquals(4, calculateScoreService.getScore(CategoryEnum.TWOS, List.of(1, 2, 3, 2, 6)));
        assertEquals(10, calculateScoreService.getScore(CategoryEnum.TWOS, List.of(2, 2, 2, 2, 2)));

    }

    @Test
    public void testThrees() {
        assertEquals(6, calculateScoreService.getScore(CategoryEnum.THREES, List.of(1, 2, 3, 2, 3)));
        assertEquals(12, calculateScoreService.getScore(CategoryEnum.THREES, List.of(2, 3, 3, 3, 3)));

    }

    @Test
    public void testFours() {
        assertEquals(12, calculateScoreService.getScore(CategoryEnum.FOURS, List.of(4, 4, 4, 5, 5)));
        assertEquals(8, calculateScoreService.getScore(CategoryEnum.FOURS, List.of(4, 4, 5, 5, 5)));
        assertEquals(4, calculateScoreService.getScore(CategoryEnum.FOURS, List.of(4, 5, 5, 5, 5)));

    }

    @Test
    public void testFives() {
        assertEquals(10, calculateScoreService.getScore(CategoryEnum.FIVES, List.of(4, 4, 4, 5, 5)));
        assertEquals(15, calculateScoreService.getScore(CategoryEnum.FIVES, List.of(4, 4, 5, 5, 5)));
        assertEquals(20, calculateScoreService.getScore(CategoryEnum.FIVES, List.of(4, 5, 5, 5, 5)));

    }

    @Test
    public void testSixes() {
        assertEquals(0, calculateScoreService.getScore(CategoryEnum.SIXES, List.of(4, 4, 4, 5, 5)));
        assertEquals(6, calculateScoreService.getScore(CategoryEnum.SIXES, List.of(4, 4, 6, 5, 5)));
        assertEquals(18, calculateScoreService.getScore(CategoryEnum.SIXES, List.of(6, 5, 6, 6, 5)));
    }

    @Test
    public void testOnePair() {
        assertEquals(6, calculateScoreService.getScore(CategoryEnum.PAIR, List.of(3, 4, 3, 5, 6)));
        assertEquals(10, calculateScoreService.getScore(CategoryEnum.PAIR, List.of(5, 3, 3, 3, 5)));
        assertEquals(12, calculateScoreService.getScore(CategoryEnum.PAIR, List.of(5, 3, 6, 6, 5)));

    }

    @Test
    public void testTwoPairs() {
        assertEquals(16, calculateScoreService.getScore(CategoryEnum.TWO_PAIRS, List.of(3, 3, 5, 4, 5)));
        assertEquals(16, calculateScoreService.getScore(CategoryEnum.TWO_PAIRS, List.of(3, 3, 5, 5, 5)));

    }

    @Test
    public void testThreeOfAKind() {
        assertEquals(9, calculateScoreService.getScore(CategoryEnum.THREE_OF_KIND, List.of(3, 3, 3, 4, 5)));
        assertEquals(15, calculateScoreService.getScore(CategoryEnum.THREE_OF_KIND, List.of(5, 3, 5, 4, 5)));
        assertEquals(9, calculateScoreService.getScore(CategoryEnum.THREE_OF_KIND, List.of(3, 3, 3, 3, 5)));
    }

    @Test
    public void testFourOfKind() {
        assertEquals(12, calculateScoreService.getScore(CategoryEnum.FOUR_OF_KIND, List.of(3, 3, 3, 3, 5)));
        assertEquals(20, calculateScoreService.getScore(CategoryEnum.FOUR_OF_KIND, List.of(5, 5, 5, 4, 5)));
        assertEquals(12, calculateScoreService.getScore(CategoryEnum.FOUR_OF_KIND, List.of(3, 3, 3, 3, 3)));

    }

    @Test
    public void testSmallStraight() {
        assertEquals(15, calculateScoreService.getScore(CategoryEnum.SMALL_STRAIGHT, List.of(1, 2, 3, 4, 5)));
        assertEquals(15, calculateScoreService.getScore(CategoryEnum.SMALL_STRAIGHT, List.of(2, 3, 4, 5, 1)));
        assertEquals(0, calculateScoreService.getScore(CategoryEnum.SMALL_STRAIGHT, List.of(1, 2, 2, 4, 5)));

    }

    @Test
    public void testLargeStraight() {
        assertEquals(20, calculateScoreService.getScore(CategoryEnum.LARGE_STRAIGHT, List.of(6, 2, 3, 4, 5)));
        assertEquals(20, calculateScoreService.getScore(CategoryEnum.LARGE_STRAIGHT, List.of(2, 3, 4, 5, 6)));
        assertEquals(0, calculateScoreService.getScore(CategoryEnum.LARGE_STRAIGHT, List.of(1, 2, 2, 4, 5)));
    }

    @Test
    public void testFullHouse() {
        assertEquals(18, calculateScoreService.getScore(CategoryEnum.FULL_HOUSE, List.of(6, 2, 2, 2, 6)));
        assertEquals(0, calculateScoreService.getScore(CategoryEnum.FULL_HOUSE, List.of(2, 3, 4, 5, 6)));

    }

}