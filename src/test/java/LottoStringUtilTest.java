import org.junit.jupiter.api.Test;
import util.LottoStringUtil;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoStringUtilTest {
    @Test
    void getUniqueLottoNumbersWithValidInput() {
        assertThat(LottoStringUtil.splitToLotteryNumbers("1,2,3,4,5,6")).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    void getUniqueLottoNumbersWithInValidInput() {
        assertThrows(IllegalArgumentException.class, () -> LottoStringUtil.splitToLotteryNumbers("1,2;,3,4,5,6"));
    }

    @Test
    void getUniqueLottoNumbersWithLargeNumber() {
        assertThrows(IllegalArgumentException.class, () -> LottoStringUtil.splitToLotteryNumbers("1,200,3,4,5,6"));
    }

    @Test
    void getUniqueLottoNumbersWithTooManyInput() {
        assertThrows(IllegalArgumentException.class, () -> LottoStringUtil.splitToLotteryNumbers("1,2,3,4,5,6,7,8"));
    }

    @Test
    void toNumberWithNumeric() {
        assertThat(LottoStringUtil.toNumber("8")).isEqualTo(8);
    }

    @Test
    void toNumberWithNull() {
        assertThrows(IllegalArgumentException.class, () -> LottoStringUtil.toNumber(null));
    }

    @Test
    void toNumberWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> LottoStringUtil.toNumber(""));
    }

    @Test
    void toNumberWithInvalidString() {
        assertThrows(IllegalArgumentException.class, () -> LottoStringUtil.toNumber("384abc"));
    }
}
