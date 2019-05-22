import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import static util.Constant.*;
import static util.Constant.EARNING_RATE_FORMAT;
import static util.LottoMap.getWinningMoneyMap;

class LottoPrinter {
    static void printLottoCountAndLottoNumbers(Set<Lotto> lottos) {
        System.out.println(String.format(PURCHASE_COUNT_FORMAT, lottos.size()));
        Arrays.stream(lottos.toArray()).forEach(System.out::println);
    }

    static void printLotteryResult(HashMap<Integer, Integer> intersectionCount, float earningRate) {
        System.out.println(WINNING_RESULT);
        printIntersectionCounts(intersectionCount);
        printEarningRate(earningRate);
    }

    private static void printIntersectionCounts(HashMap<Integer, Integer> intersectionCount) {
        HashMap<Integer, Integer> winningMoney = getWinningMoneyMap();
        for (int i=3; i < LOTTO_SIZE; i++) {
            System.out.println(String.format(INTERSECTION_COUNT_FORMAT, i, winningMoney.get(i), intersectionCount.get(i)));
        }
        System.out.println(String.format(BONUS_COUNT_FORMAT, winningMoney.get(FIVE_WITH_BONUS), intersectionCount.get(FIVE_WITH_BONUS)));
        System.out.println(String.format(INTERSECTION_COUNT_FORMAT, 6, winningMoney.get(6), intersectionCount.get(6)));
    }

    private static void printEarningRate(float earningRate) {
        System.out.println(String.format(EARNING_RATE_FORMAT, earningRate));
    }
}
