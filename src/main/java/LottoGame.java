import util.LottoStringUtil;
import util.LottoValidation;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static util.Constant.*;

class LottoGame {
    private Scanner scanner;
    Set<Lotto> lottos;
    private List<Integer> winningNumbers;
    int bonusNumber;

    LottoGame(Scanner scanner) {
        this.scanner = scanner;
        lottos = new HashSet<>();
        String amount = getUserInput(PURCHASE_AMOUNT_MSG);
        int count = getLottoCount(amount);
        generateLottos(count);
        winningNumbers = getWinningNumbers();
        bonusNumber = getBonusNumber();
    }

    private void generateLottos(int count) {
        for(int i=0; i<count; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
    }

    private String getUserInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    static int getLottoCount(String input) {
        int amount = LottoStringUtil.toNumber(input);
        return amount / PURCHASE_UNIT;
    }

    private List<Integer> getWinningNumbers() {
        return LottoStringUtil.splitToLotteryNumbers(getUserInput(WINNING_LOTTERY_MSG));
    }

    private int getBonusNumber() {
        int bonus = LottoStringUtil.toNumber(getUserInput(BONUS_BALL_MSG));
        if (!isValidBonusNumber(bonus)) {
            throw new IllegalArgumentException();
        }
        return bonus;
    }

    private boolean isValidBonusNumber(int bonus) {
        return winningNumbers.indexOf(bonus) == -1 && LottoValidation.isValidLottoNumber(bonus);
    }
}
