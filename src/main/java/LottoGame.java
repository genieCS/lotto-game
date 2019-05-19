import org.apache.commons.lang3.StringUtils;
import util.LottoStringUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static util.Constant.*;

class LottoGame {
    private Scanner scanner;
    Set<Lotto> lottos;
    private List<Integer> winningNumbers;

    LottoGame(Scanner scanner) {
        this.scanner = scanner;
        lottos = new HashSet<>();
        String amount = getUserInput(PURCHASE_AMOUNT_MSG);
        int count = getLottoCount(amount);
        generateLottos(count);
        winningNumbers = getWinningNumbers();
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
        if(!StringUtils.isNumeric(input)) {
            throw new IllegalArgumentException();
        }
        int amount = Integer.parseInt(input);
        return amount / PURCHASE_UNIT;
    }

    private List<Integer> getWinningNumbers() {
        return LottoStringUtil.splitToLotteryNumbers(getUserInput(WINNING_LOTTERY_MSG));
    }
}
