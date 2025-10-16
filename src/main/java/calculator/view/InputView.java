package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readExpression() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String firstInput = Console.readLine();
        if (firstInput.contains("/")) {
            String secondInput = Console.readLine();
            return firstInput + "\n" + secondInput;
        }

        return firstInput;
    }
}
