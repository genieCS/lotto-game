package util;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static util.Constant.*;

public class LottoValidation {
    static boolean isValidLottoInput(String[] values) {
        if (!areAllNumeric(values)) {
            return false;
        }
        List<Integer> nums = LottoStringUtil.toNumbers(values);
        return isValidLottoSize(nums) && areAllValidLottoNumber(nums) && areAllUnique(nums);
    }

    public static boolean isValidLottoSize(List<Integer> nums) { return  nums.size() == LOTTO_SIZE; }

    public static boolean isValidLottoSize(Set<Integer> values) {
        return values.size() == LOTTO_SIZE;
    }

    public static boolean areAllNumeric(String[] values) {
        return Arrays.stream(values).allMatch(StringUtils::isNumeric);
    }

    private static boolean areAllValidLottoNumber(List<Integer> nums) {
        return nums.stream().allMatch(LottoValidation::isValidLottoNumber);
    }

    public static boolean isValidLottoNumber(int num) {
        return MINIMUM_LOTTO_NUM <= num && num <= MAXIMUM_LOTTO_NUM;
    }

    public static boolean areAllUnique(List<Integer> nums) {
        return new HashSet<>(nums).size() == nums.size();
    }
}
