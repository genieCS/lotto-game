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
        assertThat(LottoValidation.isValidLottoSize(numbers)).isEqualTo(true);
    }

    @Test
    void generateLottos() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n7");
        LottoGame game = new LottoGame(scanner);
        assertThat(game.lottos.size()).isEqualTo(8);
    }

    @Test
    void getValidBonusNumber() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n7");
        LottoGame game = new LottoGame(scanner);
        assertThat(game.bonusNumber).isEqualTo(7);
    }

    @Test
    void getBonusNumberWithRedundantInput() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n6");
        assertThrows(IllegalArgumentException.class, () -> new LottoGame(scanner));
    }

    @Test
    void getBonusNumberWithLargeInput() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n400");
        assertThrows(IllegalArgumentException.class, () -> new LottoGame(scanner));
    }

    @Test
    void getBonusNumberWithInvalidInput() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n;");
        assertThrows(IllegalArgumentException.class, () -> new LottoGame(scanner));
    }
}
