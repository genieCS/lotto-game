import org.junit.jupiter.api.Test;
import util.LottoValidation;

import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoGameTest {

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
    void generateLottoNumber() {
        assertThat(LottoValidation.isValidLottoNumber(Lotto.generateLottoNumber())).isEqualTo(true);
    }

    @Test
    void generateLottoNumbers() {
        Set<Integer> numbers = new Lotto().nums;
        assertThat(numbers.stream().allMatch(LottoValidation::isValidLottoNumber)).isEqualTo(true);
        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void generateLottos() {
        Scanner scanner = new Scanner("8000");
        LottoGame game = new LottoGame(scanner);
        assertThat(game.lottos.size()).isEqualTo(8);
    }
}
