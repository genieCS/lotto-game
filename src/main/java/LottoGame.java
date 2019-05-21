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
        String amount = scanner.getPurchaseAmountInput();
        int count = getLottoCount(amount);
        issueLottos(count);
        printLottoCountAndLottoNumbers();
        List<Integer> winningNumbers = scanner.getWinningNumbersInput();
        int bonusNumber = scanner.getBonusNumberInput();
        setWinningLotto(winningNumbers, bonusNumber);
        HashMap<Integer, Integer> intersectionCount = computeIntersectionCount();
        float earningRate = getEarningRate(intersectionCount);
        printLotteryResult(intersectionCount, earningRate);
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

    private void printLottoCountAndLottoNumbers() {
        System.out.println(String.format(PURCHASE_COUNT_FORMAT, lottos.size()));
        Arrays.stream(lottos.toArray()).forEach(System.out::println);
    }

    private void setWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        winningLotto = new Lotto(winningNumbers, bonusNumber);
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

    private void printLotteryResult(HashMap<Integer, Integer> intersectionCount, float earningRate) {
        System.out.println(WINNING_RESULT);
        printIntersectionCounts(intersectionCount);
        printEarningRate(earningRate);
    }

    private void printIntersectionCounts(HashMap<Integer, Integer> intersectionCount) {
        HashMap<Integer, Integer> winningMoney = getWinningMoneyMap();
        for (int i=3; i < LOTTO_SIZE; i++) {
            System.out.println(String.format(INTERSECTION_COUNT_FORMAT, i, winningMoney.get(i), intersectionCount.get(i)));
        }
        System.out.println(String.format(BONUS_COUNT_FORMAT, winningMoney.get(FIVE_WITH_BONUS), intersectionCount.get(FIVE_WITH_BONUS)));
        System.out.println(String.format(INTERSECTION_COUNT_FORMAT, 6, winningMoney.get(6), intersectionCount.get(6)));
    }

    private void printEarningRate(float earningRate) {
        System.out.println(String.format(EARNING_RATE_FORMAT, earningRate));
    }
}
