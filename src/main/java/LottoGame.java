import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import static util.Constant.*;

class LottoGame {
    private Scanner scanner;
    int count;

    LottoGame(Scanner scanner) {
        this.scanner = scanner;
        String input = getUserInput(PURCHASE_AMOUNT_MSG);
        count = getLottoCount(input);
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

    static boolean isValidLottoNumber(int num) {
        return MINIMUM_LOTTO_NUM <= num && num <= MAXIMUM_LOTTO_NUM;
    }
}
