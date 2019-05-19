import org.junit.jupiter.api.Test;
import util.LottoValidation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    @Test
    void isValidLottoSizeWithValidInput() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        assertThat(LottoValidation.isValidLottoSize(set)).isEqualTo(true);
    }

    @Test
    void isValidLottoSizeWithSmallInput() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5));
        assertThat(LottoValidation.isValidLottoSize(set)).isEqualTo(false);
    }

    @Test
    void isValidLottoSizeWithLargeInput() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7));
        assertThat(LottoValidation.isValidLottoSize(set)).isEqualTo(false);
    }

    @Test
    void isValidLottoSize() {
        String input = "1,2,3,4,5,6";
        String[] values = input.split(",");
        assertThat(LottoValidation.isValidLottoSize(values)).isEqualTo(true);
    }

    @Test
    void isValidLottoSizeWithInvalidInput() {
        String input = "1,2,3,4,5,6,7,8";
        String[] values = input.split(",");
        assertThat(LottoValidation.isValidLottoSize(values)).isEqualTo(false);
    }

    @Test
    void areAllNumeric() {
        String input = "1,2,3,4,5,6";
        String[] values = input.split(",");
        assertThat(LottoValidation.areAllNumeric(values)).isEqualTo(true);
    }

    @Test
    void areAllUniqueWithValid() {
        String input = "1,2,3,4,5,6";
        String[] values = input.split(",");
        assertThat(LottoValidation.areAllUnique(values)).isEqualTo(true);
    }
}
