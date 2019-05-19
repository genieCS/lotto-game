import java.util.HashSet;
import java.util.Set;

import static util.Constant.LOTTO_SIZE;
import static util.Constant.MAXIMUM_LOTTO_NUM;

public class Lotto {
    private Set<Integer> nums;

    public Lotto() {
        nums = new HashSet<>();
        addUniqueLottoNumbers();
    }

    private void addUniqueLottoNumbers() {
        for (int i=0; i< LOTTO_SIZE; i++) {
            addUniqueLottoNumber();
        }
    }

    private void addUniqueLottoNumber() {
        int num;
        do {
            num = generateLottoNumber();
        } while (nums.contains(num));
        nums.add(num);
    }

    static int generateLottoNumber() {
        return (int) (Math.random() * MAXIMUM_LOTTO_NUM) + 1;
    }

    Set<Integer> getNumbers() {
        return nums;
    }
}
