import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static util.Constant.*;

class LottoGame {
    private Scanner scanner;
    Set<Lotto> lottos;

    LottoGame(Scanner scanner) {
        this.scanner = scanner;
        lottos = new HashSet<>();
        String input = getUserInput(PURCHASE_AMOUNT_MSG);
        int count = getLottoCount(input);
        generateLottos(count);

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

    static boolean isValidLottoNumber(int num) {
        return MINIMUM_LOTTO_NUM <= num && num <= MAXIMUM_LOTTO_NUM;
    }
}
