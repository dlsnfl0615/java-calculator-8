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
        try {
            // View를 통해 사용자 입력 받기
            String expression = inputView.readExpression();

            // Model에게 계산 요청하기
            BigDecimal result = calculator.add(expression);

            // View를 통해 결과 출력하기
            outputView.printResult(result);

        } catch (IllegalArgumentException e) {
            // Model에서 예외 발생 시 View를 통해 에러 메시지 출력하기
            outputView.printError(e.getMessage());
        }
    }
}
