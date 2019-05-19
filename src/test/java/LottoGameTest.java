import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.Constant.MAXIMUM_LOTTO_NUM;
import static util.Constant.MINIMUM_LOTTO_NUM;

public class LottoGameTest {

    @Test
    void getPurchaseAmountWithExactInput() {
        assertThat(LottoGame.getPurchaseAmount("8000")).isEqualTo(8000);
    }

    @Test
    void getPurchaseAmountWithRichInput() {
        assertThat(LottoGame.getPurchaseAmount("8500")).isEqualTo(8000);
    }

    @Test
    void getPurchaseAmountWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> LottoGame.getPurchaseAmount(null));
    }

    @Test
    void getPurchaseAmountWithEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> LottoGame.getPurchaseAmount(""));
    }

    @Test
    void getPurchaseAmountWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> LottoGame.getPurchaseAmount("384abc"));
    }

    @Test
    void isValidLottoNumberWithMinValidNumber() {
        assertThat(LottoGame.isValidLottoNumber(MINIMUM_LOTTO_NUM)).isEqualTo(true);
    }

    @Test
    void isValidLottoNumberWitValidNumber() {
        assertThat(LottoGame.isValidLottoNumber(5)).isEqualTo(true);
    }

    @Test
    void isValidLottoNumberWithMaxValidNumber() {
        assertThat(LottoGame.isValidLottoNumber(MAXIMUM_LOTTO_NUM)).isEqualTo(true);
    }

    @Test
    void isValidLottoNumberWithInvalidSmallNumber() {
        assertThat(LottoGame.isValidLottoNumber(MINIMUM_LOTTO_NUM-1)).isEqualTo(false);
    }

    @Test
    void isValidLottoNumberWithInvalidLargeNumber() {
        assertThat(LottoGame.isValidLottoNumber(MAXIMUM_LOTTO_NUM+1)).isEqualTo(false);
    }

    @Test
    void generateLottoNumber() {
        assertThat(LottoGame.isValidLottoNumber(Lotto.generateLottoNumber())).isEqualTo(true);
    }

    @Test
    void generateLottoNumbers() {
        Set<Integer> numbers = new Lotto().getNumbers();
        assertThat(numbers.stream().allMatch(LottoGame::isValidLottoNumber)).isEqualTo(true);
        assertThat(numbers.size()).isEqualTo(6);
    }
}
