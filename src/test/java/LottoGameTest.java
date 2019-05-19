import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.Constant.MAXIMUM_LOTTO_NUM;
import static util.Constant.MINIMUM_LOTTO_NUM;

public class LottoGameTest {

    @Test
    void getLottoCountWithExactInput() {
        assertThat(LottoGame.getLottoCount("8000")).isEqualTo(8);
    }

    @Test
    void getLottoCountWithRichInput() {
        assertThat(LottoGame.getLottoCount("8500")).isEqualTo(8);
    }

    @Test
    void getLottoCountWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> LottoGame.getLottoCount(null));
    }

    @Test
    void getLottoCountWithEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> LottoGame.getLottoCount(""));
    }

    @Test
    void getLottoCountWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> LottoGame.getLottoCount("384abc"));
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
        Set<Integer> numbers = new Lotto().nums;
        assertThat(numbers.stream().allMatch(LottoGame::isValidLottoNumber)).isEqualTo(true);
        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void generateLottos() {
        Scanner scanner = new Scanner("8000");
        LottoGame game = new LottoGame(scanner);
        assertThat(game.lottos.size()).isEqualTo(8);
    }
}
