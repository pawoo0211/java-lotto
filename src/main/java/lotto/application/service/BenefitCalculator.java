package lotto.application.service;

import lotto.application.dto.LottoRequest;
import lotto.application.dto.LottoResponse;
import lotto.domain.Lottos;
import lotto.domain.WinningAmount;

import java.util.HashMap;

public class BenefitCalculator {

    public LottoResponse calculateBenefit(LottoRequest request) {
        Lottos lottos = new Lottos(request.getLottos(), request.getWinningLottoNumber());
        HashMap<WinningAmount, Integer> countAllWinning = lottos.countAllWinning();
        String rateOfReturn = calculateRateOfReturn(request.getInputAmount(), countAllWinning);
        return new LottoResponse(rateOfReturn, countAllWinning);
    }

    private String calculateRateOfReturn(Integer inputAmount, HashMap<WinningAmount, Integer> countAllWinning) {
        Integer getAllAmount = 0;
        for (WinningAmount winningAmount : countAllWinning.keySet()) {
            getAllAmount += (winningAmount.getAmount() * countAllWinning.get(winningAmount));
        }
        Double result = Double.valueOf(getAllAmount) / Double.valueOf(inputAmount);
        return String.format("%.2f", result);
    }
}
