import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static util.Constant.FIVE_WITH_BONUS;

class LottoTest {
    @Test
    void intersectionSizeWithSame() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto1 = new Lotto(numbers);
        Lotto lotto2 = new Lotto(numbers);
        assertThat(lotto1.intersectionSize(lotto2)).isEqualTo(numbers.size());
    }

    @Test
    void intersectionSizeWithDisjointSet() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(7,8,9,10,11,12));
        assertThat(lotto1.intersectionSize(lotto2)).isEqualTo(0);
    }

    @Test
    void intersectionSizeWithDifferentSet() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,7,8,9));
        assertThat(lotto1.intersectionSize(lotto2)).isEqualTo(3);
    }

    @Test
    void winningMoneyWithZero() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(7,8,9,10,11,12));
        assertThat(lotto1.winningIndex(lotto2)).isEqualTo(0);
    }

    @Test
    void winningMoneyWithOne() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(1,7,8,9,10,11));
        assertThat(lotto1.winningIndex(lotto2)).isEqualTo(1);
    }

    @Test
    void winningMoneyWithTwo() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,7,8,9,10));
        assertThat(lotto1.winningIndex(lotto2)).isEqualTo(2);
    }

    @Test
    void winningMoneyWithThree() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,7,8,9));
        assertThat(lotto1.winningIndex(lotto2)).isEqualTo(3);
    }

    @Test
    void winningMoneyWithFour() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,4,7,8));
        assertThat(lotto1.winningIndex(lotto2)).isEqualTo(4);
    }

    @Test
    void winningMoneyWithFive() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,4,5,7));
        assertThat(lotto1.winningIndex(lotto2)).isEqualTo(5);
    }

    @Test
    void winningMoneyWithFiveAndBonus() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6), 7);
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,4,5,7));
        assertThat(lotto1.winningIndex(lotto2)).isEqualTo(FIVE_WITH_BONUS);
    }

    @Test
    void winningMoneyWithSix() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto1 = new Lotto(numbers);
        Lotto lotto2 = new Lotto(numbers);
        assertThat(lotto1.winningIndex(lotto2)).isEqualTo(6);
    }
}
