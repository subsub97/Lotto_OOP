package utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;

public class Validator {
    private static final String STRING_TO_INTEGER_ERROR = "[ERROR] 입력 값은 숫자로만 이루어져 있어야 합니다.";
    private static final String INPUT_IS_EMPTY = "[ERROR] 입력 값이 없습니다.";
    private static final String ERROR_NOT_SIX_NUMBER_COUNT = "[ERROR] 로또 번호는 6개 입력이 필요합니다.";
    private static final String ERROR_HAVE_OVERLAP_NUMBERS = "[ERROR] 중복된 번호를 입력 하였습니다.";
    public static final String ERROR_OUT_OF_RANGE = "[ERROR] 로또 번호는 1 ~ 45 사이로 발급되어야 합니다.";
    public static String ERROR_LOWER_MIN_PHUCHASE_PRICE = "[ERROR] 최소 구매가능 금액은 1000원 입니다.";
    public static String ERROR_INVALID_AMOUNT_FORMAT = "[ERROR] 구매금액은 1,000단위로 입력하여야 합니다.";

    public static void validateNumericValue(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(STRING_TO_INTEGER_ERROR);
        }
    }

    public static void validateIsEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY);
        }
    }


    public static void validateSixNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_NOT_SIX_NUMBER_COUNT);
        }
    }

    public static void validateOverlapNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ERROR_HAVE_OVERLAP_NUMBERS);
            }
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(Validator::validateSingleNumberRange);
    }

    public static void validateSingleNumberRange(Integer number) {
        if (number < Lotto.MIN_LOTTO_NUMBER || number > Lotto.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }

    public static void validateUnderThousand(String userInput) {
        if (Integer.parseInt(userInput) < 1000) {
            throw new IllegalArgumentException(ERROR_LOWER_MIN_PHUCHASE_PRICE);
        }
    }

    public static void validateMulitpleOfThousand(String userInput) {
        if (Integer.parseInt(userInput) % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_AMOUNT_FORMAT);
        }
    }
}
