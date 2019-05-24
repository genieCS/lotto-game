import util.LottoValidation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static util.Constant.FIVE_WITH_BONUS;

class WinningLotto extends Lotto {
    private int bonus;

    WinningLotto(List<Integer> nums, int bonus) {
        super(nums);
        if (!isValidBonusNumber(bonus)) {
            throw new IllegalArgumentException();
        }
        this.bonus = bonus;
    }

    private boolean isValidBonusNumber(int bonus) {
        return !nums.contains(bonus) && LottoValidation.isValidLottoNumber(bonus);
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

    private int intersectionSize(Lotto other) {
        Set<Integer> intersection = new HashSet<>(nums);
        intersection.retainAll(other.nums);
        return intersection.size();
    }
}
