package util;

import java.util.HashMap;

import static util.Constant.FIVE_WITH_BONUS;
import static util.Constant.mapSize;

public class LottoMap {
    static public HashMap<Integer, Integer> getWinningMoneyMap() {
        final HashMap<Integer, Integer> winningMoney = new HashMap<>();
        winningMoney.put(3, 5000);
        winningMoney.put(4, 50000);
        winningMoney.put(5, 150000);
        winningMoney.put(6, 2000000000);
        winningMoney.put(FIVE_WITH_BONUS, 30000000);
        return winningMoney;
    }

    static public HashMap<Integer, Integer> initIntersectionCount() {
        final HashMap<Integer, Integer> winningCount = new HashMap<>();
        for(int i=0; i< mapSize; i++) {
            winningCount.put(i, 0);
        }
        return winningCount;
    }
}
