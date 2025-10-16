package calculator.view;

import java.math.BigDecimal;

public class OutputView {
    public void printResult(BigDecimal result) {
        System.out.println("결과 : " + result);
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
