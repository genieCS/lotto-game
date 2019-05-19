import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class LottoGame {
    private static final int PURCHASE_UNIT = 1000;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = getUserInput("구입금액을 입력해 주세요.");
        int amount = getPurchaseAmount(input);
    }

    static String getUserInput(String message) {
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

}
