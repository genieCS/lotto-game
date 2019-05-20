import java.util.*;

import static util.Constant.*;

public class Lotto {
    Set<Integer> nums;
    private int bonus;

    Lotto() {
        nums = new HashSet<>();
        addUniqueLottoNumbers();
        bonus = 0;
    }

    Lotto(List<Integer> nums) {
        this(nums, 0);
    }

    Lotto(List<Integer> nums, int bonus) {
        this.nums = new HashSet<>(nums);
        this.bonus = bonus;
    }

    int winningIndex(Lotto other) {
        int size = intersectionSize(other);
        if (isGeneralCase(other, size)) {
            return  size;
        }
        return FIVE_WITH_BONUS;
    }

    private boolean isGeneralCase(Lotto other, int size) {
        return !(size == 5 && other.nums.contains(bonus));
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
