package calculator.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private final Validator validator = new Validator();
    private final CustomDelimiter customDelimiter = new CustomDelimiter();

    public List<BigDecimal> parse(String text) {
        // 커스텀 구분자가 있는지 확인하고, 있다면 구분자와 숫자 문자열 분리
        String[] parts = customDelimiter.separate(text);
        String delimiter = parts[0];
        String numbersText = parts[1];

        // 구분자를 기준으로 문자열을 잘라 숫자 문자열 배열 생성
        String[] stringNumbers = numbersText.split(delimiter);

        return Arrays.stream(stringNumbers)
                .map(validator::validateAndParse)
                .collect(Collectors.toList());
    }
}
