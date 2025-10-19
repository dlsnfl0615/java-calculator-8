package calculator.controller;
import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.math.BigDecimal;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public CalculatorController(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }

    public void run() {
        // View를 통해 사용자 입력 받기
        String expression = inputView.readExpression();

        // Model에게 계산 요청하기
        BigDecimal result = calculator.add(expression);

        // View를 통해 결과 출력하기
        outputView.printResult(result);
    }
}
