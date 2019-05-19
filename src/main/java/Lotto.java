import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static util.Constant.LOTTO_SIZE;
import static util.Constant.MAXIMUM_LOTTO_NUM;

public class Lotto {
    Set<Integer> nums;

    public Lotto() {
        nums = new HashSet<>();
        addUniqueLottoNumbers();
    }

    Lotto(List<Integer> nums) {
        this.nums = new HashSet<>(nums);
    }

    int intersectionSize(Lotto other) {
        Set<Integer> intersection = new HashSet<>(nums);
        intersection.retainAll(other.nums);
        return intersection.size();
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
