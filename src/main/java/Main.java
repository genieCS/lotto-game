import util.LottoScanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LottoScanner lottoScanner = new LottoScanner(System.in);
        new LottoGame(lottoScanner);
    }
}
