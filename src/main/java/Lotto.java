import java.util.*;

import static util.Constant.*;

public class Lotto {
    Set<Integer> nums;
    private int bonus;
    final Map<Integer, Integer> moneys = new HashMap<>();

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
        moneys.put(3, 5000);
        moneys.put(4, 50000);
        moneys.put(5, 150000);
        moneys.put(6, 2000000000);
        moneys.put(FIVE_WITH_BONUS, 30000000);
    }

    int winningMoney(Lotto other) {
        int size = intersectionSize(other);
        if (isGeneralCase(other, size)) {
            return moneys.getOrDefault(size, 0);
        }
        return moneys.get(FIVE_WITH_BONUS);
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
