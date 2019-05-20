import util.LottoStringUtil;

import java.util.*;

import static util.Constant.*;
import static util.LottoMap.initWinningCount;
import static util.LottoMap.initWinningMoney;

class LottoGame {
    private Scanner scanner;
    Set<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int count;
    private Lotto winningLotto;
    final HashMap<Integer, Integer> winningMoney = initWinningMoney();
    final HashMap<Integer, Integer> winningCount = initWinningCount();
    int amount = 0;

    LottoGame(Scanner scanner) {
        this.scanner = scanner;
        lottos = new HashSet<>();
        issueLottos();
        setWinningLotto();
        computeWinningCount();
        printLotteryResult();
    }

    private void issueLottos() {
        String amount = getUserInput(PURCHASE_AMOUNT_MSG);
        count = getLottoCount(amount);
        generateLottos(count);
        printLottoNumbers();
    }

    private void setWinningLotto() {
        winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        winningLotto = new Lotto(winningNumbers, bonusNumber);
    }

    int getEarningMoney(HashMap<Integer, Integer> winningCount) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : winningCount.entrySet()) {
            Integer idx = entry.getKey();
            Integer value = entry.getValue();
            sum += winningMoney.getOrDefault(idx, 0) * value;
        }
        return sum;
    }

    private float getEarningRate() {
        int earningMoney = getEarningMoney(winningCount);
        float amount = count * PURCHASE_UNIT;
        return earningMoney / amount;
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

    private void increaseWinningCount(int idx) {
        int prev = winningCount.getOrDefault(idx, 0);
        winningCount.put(idx, prev + 1);
    }

    private void computeWinningCount() {
        new ArrayList<>(lottos).stream().mapToInt(winningLotto::winningIndex).forEach(this::increaseWinningCount);
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
        return LottoStringUtil.toNumber(getUserInput(BONUS_BALL_MSG));
    }

    private void printLotteryResult() {
        System.out.println(WINNING_RESULT);
        printIntersectionCounts();
        float earningRate = getEarningRate();
        System.out.println(String.format(EARNING_RATE_FORMAT, earningRate));
    }

    private void printIntersectionCounts() {
        for (int i=3; i < LOTTO_SIZE; i++) {
            System.out.println(String.format(INTERSECTION_COUNT_FORMAT, i, winningMoney.get(i), winningCount.get(i)));
        }
        System.out.println(String.format(BONUS_COUNT_FORMAT, winningMoney.get(FIVE_WITH_BONUS), winningCount.get(FIVE_WITH_BONUS)));
        System.out.println(String.format(INTERSECTION_COUNT_FORMAT, 6, winningMoney.get(6), winningCount.get(6)));
    }
}
