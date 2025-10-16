package calculator.model;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {
    private final InputParser inputParser = new InputParser();

    public BigDecimal add(String text) {
        // 빈 문자열이나 null이 들어오면 0을 반환
        if (text == null || text.isEmpty()) {
            return new BigDecimal(0);
        }

        // 1. InputParser에게 문자열을 숫자 리스트로 변환 요청
        List<BigDecimal> numbers = inputParser.parse(text);

        // 2. 숫자 리스트의 합계를 계산하여 반환
        return numbers.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
