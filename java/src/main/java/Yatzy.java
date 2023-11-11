import java.util.Arrays;
import java.util.stream.IntStream;

public class Yatzy {

    public static int chance(int... dice) {
        return Arrays.stream(dice).sum();
    }

    public static int yatzy(int... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        return IntStream.of(counts).anyMatch(count -> count == 5) ? 50 : 0;
    }

    public static int ones(int... dice) {
        return countSpecificNumber(dice, 1);
    }

    public static int twos(int... dice) {
        return countSpecificNumber(dice, 2) * 2;
    }

    public static int threes(int... dice) {
        return countSpecificNumber(dice, 3) * 3;
    }

    public static int fours(int... dice) {
        return countSpecificNumber(dice, 4) * 4;
    }

    public static int fives(int... dice) {
        return countSpecificNumber(dice, 5) * 5;
    }

    public static int sixes(int... dice) {
        return countSpecificNumber(dice, 6) * 6;
    }

    public static int score_pair(int... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= 2) {
                return (i + 1) * 2;
            }
        }
        return 0;
    }

    public static int two_pair(int... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        int pairs = 0;
        int score = 0;
        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= 2) {
                pairs++;
                score += (i + 1) * 2;
            }
        }
        return (pairs == 2) ? score : 0;
    }

    public static int three_of_a_kind(int... dice) {
        return findForKind(dice, 3);
    }

    public static int four_of_a_kind(int... dice) {
        return findForKind(dice, 4);
    }

    public static int smallStraight(int... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        return Arrays.equals(counts, new int[]{1, 1, 1, 1, 1, 0}) ? 15 : 0;
    }

    public static int largeStraight(int... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        return Arrays.equals(counts, new int[]{0, 1, 1, 1, 1, 1}) ? 20 : 0;
    }

    public static int fullHouse(int... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        return Arrays.stream(counts).anyMatch(count -> count == 2) &&
            Arrays.stream(counts).anyMatch(count -> count == 3) ? Arrays.stream(dice).sum() : 0;
    }

    private static int countSpecificNumber(int[] dice, int number) {
        return (int) Arrays.stream(dice).filter(die -> die == number).count();
    }

    private static int findForKind(int[] dice, int kind) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= kind) {
                return (i + 1) * kind;
            }
        }
        return 0;
    }
}
