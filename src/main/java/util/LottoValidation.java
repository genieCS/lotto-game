package util;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static util.Constant.*;

public class LottoValidation {
    static boolean isValidLottoInput(String[] values) {
        return isValidLottoSize(values) && areAllNumeric(values) && areAllValidLottoNumber(values) && areAllUnique(values);
    }

    public static boolean isValidLottoSize(String[] values) {
        return values.length == LOTTO_SIZE;
    }

    public static boolean isValidLottoSize(Set<Integer> values) {
        return values.size() == LOTTO_SIZE;
    }

    public static boolean areAllNumeric(String[] values) {
        return Arrays.stream(values).allMatch(StringUtils::isNumeric);
    }

    private static boolean areAllValidLottoNumber(String[] values) {
        return Arrays.stream(values).map(Integer::parseInt).allMatch(LottoValidation::isValidLottoNumber);
    }

    public static boolean isValidLottoNumber(int num) {
        return MINIMUM_LOTTO_NUM <= num && num <= MAXIMUM_LOTTO_NUM;
    }

    public static boolean areAllUnique(String[] values) {
        return new HashSet<>(Arrays.asList(values)).size() == values.length;
    }
}
