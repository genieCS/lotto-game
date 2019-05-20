import org.junit.jupiter.api.Test;
import util.LottoMap;
import util.LottoValidation;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.Constant.FIVE_WITH_BONUS;

class LottoGameTest {
    @Test
    void generateLottoNumber() {
        assertThat(LottoValidation.isValidLottoNumber(Lotto.generateLottoNumber())).isEqualTo(true);
    }

    @Test
    void generateLottoNumbers() {
        Set<Integer> numbers = new Lotto().nums;
        assertThat(numbers.stream().allMatch(LottoValidation::isValidLottoNumber)).isEqualTo(true);
        assertThat(LottoValidation.isValidLottoSize(numbers)).isEqualTo(true);
    }

    @Test
    void generateLottos() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n7");
        LottoGame game = new LottoGame(scanner);
        assertThat(game.lottos.size()).isEqualTo(8);
    }

    @Test
    void getBonusNumberWithInvalidInput() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n;");
        assertThrows(IllegalArgumentException.class, () -> new LottoGame(scanner));
    }

    @Test
    void calculateEarningMoneyWithZero() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n7");
        LottoGame game = new LottoGame(scanner);
        HashMap<Integer, Integer> winningCount = LottoMap.initIntersectionCount();
        winningCount.put(0, 1);
        assertThat(game.getEarningMoney(winningCount)).isEqualTo(0);
    }

    @Test
    void calculateEarningMoneyWithOne() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n7");
        LottoGame game = new LottoGame(scanner);
        HashMap<Integer, Integer> winningCount = LottoMap.initIntersectionCount();
        winningCount.put(1, 1);
        assertThat(game.getEarningMoney(winningCount)).isEqualTo(0);
    }

    @Test
    void calculateEarningMoneyWithTwo() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n7");
        LottoGame game = new LottoGame(scanner);
        HashMap<Integer, Integer> winningCount = LottoMap.initIntersectionCount();
        winningCount.put(2, 1);
        assertThat(game.getEarningMoney(winningCount)).isEqualTo(0);
    }

    @Test
    void calculateEarningMoneyWithhree() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n7");
        LottoGame game = new LottoGame(scanner);
        HashMap<Integer, Integer> winningCount = LottoMap.initIntersectionCount();
        winningCount.put(3, 1);
        assertThat(game.getEarningMoney(winningCount)).isEqualTo(5000);
    }

    @Test
    void calculateEarningMoneyWithFour() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n7");
        LottoGame game = new LottoGame(scanner);
        HashMap<Integer, Integer> winningCount = LottoMap.initIntersectionCount();
        winningCount.put(4, 1);
        assertThat(game.getEarningMoney(winningCount)).isEqualTo(50000);
    }

    @Test
    void calculateEarningMoneyWithFive() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n7");
        LottoGame game = new LottoGame(scanner);
        HashMap<Integer, Integer> winningCount = LottoMap.initIntersectionCount();
        winningCount.put(5, 1);
        assertThat(game.getEarningMoney(winningCount)).isEqualTo(150000);
    }

    @Test
    void calculateEarningMoneyWithSix() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n7");
        LottoGame game = new LottoGame(scanner);
        HashMap<Integer, Integer> winningCount = LottoMap.initIntersectionCount();
        winningCount.put(6, 1);
        assertThat(game.getEarningMoney(winningCount)).isEqualTo(2000000000);
    }

    @Test
    void calculateEarningMoneyWithBonus() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n7");
        LottoGame game = new LottoGame(scanner);
        HashMap<Integer, Integer> winningCount = LottoMap.initIntersectionCount();
        winningCount.put(FIVE_WITH_BONUS, 1);
        assertThat(game.getEarningMoney(winningCount)).isEqualTo(30000000);
    }

    @Test
    void calculateEarningMoneyWithMultiple() {
        Scanner scanner = new Scanner("8000\n1,2,3,4,5,6\n7");
        LottoGame game = new LottoGame(scanner);
        HashMap<Integer, Integer> winningCount = LottoMap.initIntersectionCount();
        winningCount.put(FIVE_WITH_BONUS, 1);
        winningCount.put(6, 2);
        int earningMoney = 2000000000*2 + 30000000;
        assertThat(game.getEarningMoney(winningCount)).isEqualTo(earningMoney);
    }
}
