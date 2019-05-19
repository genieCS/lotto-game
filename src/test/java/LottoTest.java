import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}
