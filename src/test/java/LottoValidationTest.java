import org.junit.jupiter.api.Test;
import util.LottoValidation;

import static org.assertj.core.api.Assertions.assertThat;
import static util.Constant.MAXIMUM_LOTTO_NUM;
import static util.Constant.MINIMUM_LOTTO_NUM;

class LottoValidationTest {
    @Test
    void isValidLottoNumberWithMinValidNumber() {
        assertThat(LottoValidation.isValidLottoNumber(MINIMUM_LOTTO_NUM)).isEqualTo(true);
    }

    @Test
    void isValidLottoNumberWitValidNumber() {
        assertThat(LottoValidation.isValidLottoNumber(5)).isEqualTo(true);
    }

    @Test
    void isValidLottoNumberWithMaxValidNumber() {
        assertThat(LottoValidation.isValidLottoNumber(MAXIMUM_LOTTO_NUM)).isEqualTo(true);
    }

    @Test
    void isValidLottoNumberWithInvalidSmallNumber() {
        assertThat(LottoValidation.isValidLottoNumber(MINIMUM_LOTTO_NUM-1)).isEqualTo(false);
    }

    @Test
    void isValidLottoNumberWithInvalidLargeNumber() {
        assertThat(LottoValidation.isValidLottoNumber(MAXIMUM_LOTTO_NUM+1)).isEqualTo(false);
    }
}
