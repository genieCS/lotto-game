package util;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static util.Constant.*;

public class LottoScanner {
    private final Scanner scanner;

    public LottoScanner(String source) {
        this.scanner = new Scanner(source);
    }

    public LottoScanner(InputStream source) {
        this.scanner = new Scanner(source);
    }

    public int getPurchaseAmountInput() {
        int amount = LottoStringUtil.toNumber(getUserInput(PURCHASE_AMOUNT_MSG));
        if (amount < PURCHASE_UNIT) {
            throw new IllegalArgumentException();
        }
        return amount;
    }

    public List<Integer> getWinningNumbersInput() {
        return LottoStringUtil.splitToLotteryNumbers(getUserInput(WINNING_LOTTERY_MSG));
    }

    public int getBonusNumberInput() {
        return LottoStringUtil.toNumber(getUserInput(BONUS_BALL_MSG));
    }

    private String getUserInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
