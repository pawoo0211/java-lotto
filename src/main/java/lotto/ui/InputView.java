package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final String DELIMITER_COMMA_EMPTY = "\\s*,\\s*";
    private final int LOTTO_PRICE = 1000;

    public Integer inputAmount() {
        System.out.println("로또 구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String amount = scanner.nextLine();
        return Integer.parseInt(amount);
    }

    public List<Lotto> calculateLottoCount(Integer amount) {
        Integer lottoCount = amount / LOTTO_PRICE;
        System.out.println(lottoCount + "개를 구입했습니다.");
        return generateLottos(lottoCount);
    }

    private List<Lotto> generateLottos(Integer lottoCount) {
        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottos = generator.generateByInputNumber(lottoCount);
        printLottos(lottos);
        return lottos;
    }

    private void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println("");
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String winningNumber = scanner.nextLine();
        return convertToLottoNumber(winningNumber);
    }

    private List<Integer> convertToLottoNumber(String winningNumber) {
        List<Integer> winningLottoNumber = new ArrayList<>(6);
        String[] numbers = winningNumber.split(DELIMITER_COMMA_EMPTY);
        for (String number : numbers) {
            winningLottoNumber.add(Integer.valueOf(number));
        }
        return winningLottoNumber;
    }
}
