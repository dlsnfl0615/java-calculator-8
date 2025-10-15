package calculator.model;

import java.math.BigDecimal;

public class Validator {

    // 문자열을 검증하고 숫자로 파싱하여 반환
    public BigDecimal validateAndParse(String numberText) {
        try {
            BigDecimal number = new BigDecimal(numberText);
            // 음수인지 검증
            if (number.compareTo(BigDecimal.ZERO) == -1) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            // 숫자로 변환할 수 없는 경우 예외 발생
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}