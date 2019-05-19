package util;

import static util.Constant.MAXIMUM_LOTTO_NUM;
import static util.Constant.MINIMUM_LOTTO_NUM;

public class LottoValidation {
    public static boolean isValidLottoNumber(int num) {
        return MINIMUM_LOTTO_NUM <= num && num <= MAXIMUM_LOTTO_NUM;
    }
}
