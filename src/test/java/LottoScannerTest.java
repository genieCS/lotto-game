import org.junit.jupiter.api.Test;
import util.LottoStringUtil;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoScannerTest {
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
}
