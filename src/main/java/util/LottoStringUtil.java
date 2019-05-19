package util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoStringUtil {
    public static List<Integer> splitToLotteryNumbers(String input) {
        return toNumbers(split(input));
    }

    private static  String[] split(String input) {
        String[] values = input.split(",");
        if (!LottoValidation.isValidLottoInput(values)) {
            throw new IllegalArgumentException();
        }
        return values;
    }

    private static List<Integer> toNumbers(String[] values) {
        return Arrays.stream(values).map(Integer::parseInt).collect(toList());
    }
}
