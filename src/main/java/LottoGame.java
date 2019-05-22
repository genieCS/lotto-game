import util.LottoScanner;
import util.LottoStringUtil;

import java.util.*;

import static util.Constant.*;
import static util.LottoMap.initIntersectionCount;
import static util.LottoMap.getWinningMoneyMap;

class LottoGame {
    private LottoScanner scanner;
    Set<Lotto> lottos;
    private Lotto winningLotto;

    LottoGame(LottoScanner scanner) {
        this.scanner = scanner;
        lottos = new HashSet<>();
        startGame();
    }

    private void startGame() {
        issueLottos(getLottoCount(scanner.getPurchaseAmountInput()));
        LottoPrinter.printLottoCountAndLottoNumbers(lottos);
        winningLotto = new Lotto(scanner.getWinningNumbersInput(), scanner.getBonusNumberInput());
        HashMap<Integer, Integer> intersectionCount = computeIntersectionCount();
        float earningRate = getEarningRate(intersectionCount);
        LottoPrinter.printLotteryResult(intersectionCount, earningRate);
    }

    private int getLottoCount(String input) {
        int amount = LottoStringUtil.toNumber(input);
        return amount / PURCHASE_UNIT;
    }

    private void issueLottos(int count) {
        for(int i = 0; i< count; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
    }

    private HashMap<Integer, Integer> computeIntersectionCount() {
        HashMap<Integer, Integer> intersectionCount = initIntersectionCount();
        new ArrayList<>(lottos).stream().mapToInt(winningLotto::winningIndex).forEach(idx -> {
            increaseIntersectionCount(intersectionCount, idx);
        });
        return intersectionCount;
    }

    private void increaseIntersectionCount(HashMap<Integer, Integer> intersectionCount, int idx) {
        int prev = intersectionCount.getOrDefault(idx, 0);
        intersectionCount.put(idx, prev + 1);
    }

    private float getEarningRate(HashMap<Integer, Integer> intersectionCount) {
        int earningMoney = getEarningMoney(intersectionCount);
        int count = lottos.size();
        float amount = count * PURCHASE_UNIT;
        return earningMoney / amount;
    }

    int getEarningMoney(HashMap<Integer, Integer> winningCount) {
        HashMap<Integer, Integer> winningMoney = getWinningMoneyMap();
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : winningCount.entrySet()) {
            Integer idx = entry.getKey();
            Integer value = entry.getValue();
            sum += winningMoney.getOrDefault(idx, 0) * value;
        }
        return sum;
    }
}
