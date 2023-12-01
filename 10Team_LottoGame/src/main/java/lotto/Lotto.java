package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import utils.Validator;

public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_LENGTH = 6;
    public static final int LOTTO_PRICE = 1000;
    public static final int DEFAULT_CORRECT_COUNT = 0;

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        Validator.validateSixNumberCount(numbers);
        Validator.validateOverlapNumber(numbers);
        Validator.validateNumberRange(numbers);
        this.numbers = sortingAscendingNumbers(numbers);
    }

    public int countCorrectLottoNumber(List<Integer> prizeNumbers) {
        int correctNumberCount = DEFAULT_CORRECT_COUNT;

        for (Integer number : numbers) {
            if (prizeNumbers.contains(number)) {
                correctNumberCount++;
            }
        }

        return correctNumberCount;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private List<Integer> sortingAscendingNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Comparator.naturalOrder());
        return sortedNumbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}