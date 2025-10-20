package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.Console;

import java.math.BigDecimal;
import java.util.List;

public class InputParserTest {
    @Test
    @DisplayName("기본 구분자로 나뉜 숫자 리스트 반환")
    void list_divided_by_default() {
        InputParser inputParser = new InputParser();
        String input = "1,2:3";
        List<BigDecimal> numbers = inputParser.parse(input);
        Assertions.assertThat(numbers).containsExactly(new BigDecimal(1),  new BigDecimal(2), new BigDecimal(3));
    }

    @Test
    @DisplayName("커스텀 구분자로 나뉜 숫자 리스트 반환")
    void list_divided_by_custom() {
        InputParser inputParser = new InputParser();
        String input = "//%\\n1%2%3";
        List<BigDecimal> numbers = inputParser.parse(input);
        Assertions.assertThat(numbers).containsExactly(new BigDecimal(1),  new BigDecimal(2), new BigDecimal(3));
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자로 나뉜 숫자 리스트 반환")
    void list_divided_by_custom_default() {
        InputParser inputParser = new InputParser();
        String input = "//%\\n1,2%3:4";
        List<BigDecimal> numbers = inputParser.parse(input);
        Assertions.assertThat(numbers).containsExactly(new BigDecimal(1),  new BigDecimal(2), new BigDecimal(3), new BigDecimal(4));
    }
}
