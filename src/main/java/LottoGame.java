import util.LottoStringUtil;
import util.LottoValidation;

import java.util.*;

import static util.Constant.*;

class LottoGame {
    private Scanner scanner;
    Set<Lotto> lottos;
    private List<Integer> winningNumbers;
    int bonusNumber;
    private int count;
    private Lotto winningLotto;

    LottoGame(Scanner scanner) {
        this.scanner = scanner;
        lottos = new HashSet<>();
        String amount = getUserInput(PURCHASE_AMOUNT_MSG);
        count = getLottoCount(amount);
        generateLottos(count);
        printLottoNumbers();
        winningNumbers = getWinningNumbers();
        bonusNumber = getBonusNumber();
        winningLotto = new Lotto(winningNumbers, bonusNumber);
    }

    private void printLottoNumbers() {
        System.out.println(String.format(PURCHASE_COUNT_FORMAT, count));
        Arrays.stream(lottos.toArray()).forEach(System.out::println);
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
