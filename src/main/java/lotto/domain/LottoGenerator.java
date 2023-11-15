package lotto.domain;

import java.util.*;

public class LottoGenerator {
    private static final List<Integer> DUMMY_LOTTO_NUMBERS = new ArrayList<>();

    private Random random = new Random();

    static {
        for (int number = 1; number < 46; number++) {
            DUMMY_LOTTO_NUMBERS.add(number);
        }
    }

    public List<Lotto> generateByLottoCount(Integer lottoCount) {
        checkLottoCount(lottoCount);
        List<Lotto> lottoList = new ArrayList<>();
        for (int index = 0; index < lottoCount; index++) {
            lottoList.add(generate());
        }
        return lottoList;
    }

    private void checkLottoCount(Integer lottoCount) {
        if (lottoCount == null || lottoCount == 0) {
            throw new IllegalArgumentException("Pay more than 1000 won");
        }
    }

    public Lotto generate() {
        Collections.shuffle(DUMMY_LOTTO_NUMBERS, random);
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(DUMMY_LOTTO_NUMBERS.get(i));
        }
        return new Lotto(lottoNumbers);
    }
}