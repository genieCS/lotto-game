import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import static util.Constant.*;

public class LottoGame {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = getUserInput(PURCHASE_AMOUNT_MSG);
        int amount = getPurchaseAmount(input);
    }

    private static String getUserInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    static int getPurchaseAmount(String input) {
        if(!StringUtils.isNumeric(input)) {
            throw new IllegalArgumentException();
        }
        int amount = Integer.parseInt(input);
        return (amount / PURCHASE_UNIT ) * PURCHASE_UNIT;
    }

    static boolean isValidLottoNumber(int num) {
        return MINIMUM_LOTTO_NUM <= num && num <= MAXIMUM_LOTTO_NUM;
    }
}
