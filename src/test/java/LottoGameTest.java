import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
