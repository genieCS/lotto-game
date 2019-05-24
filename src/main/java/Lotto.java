import util.LottoValidation;

import java.util.*;

import static util.Constant.*;

public class Lotto {
    Set<Integer> nums;
    int bonus;

    Lotto() {
        nums = new HashSet<>();
        addUniqueLottoNumbers();
        bonus = 0;
    }

    Lotto(List<Integer> nums) {
        this.nums = new HashSet<>(nums);
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

    @Override
    public String toString() {
        return Arrays.toString(nums.toArray());
    }
}
