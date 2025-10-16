package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CalculatorTest {
    @Test
    @DisplayName("자연수 덧셈")
    void add_natural_number() {
        Calculator calculator = new Calculator();
        BigDecimal sum = calculator.add("1,2,3");
        Assertions.assertThat(sum).isEqualTo(new BigDecimal(6));
    }

    @Test
    @DisplayName("실수 덧셈")
    void add_real_number() {
        Calculator calculator = new Calculator();
        BigDecimal sum = calculator.add("1,2.45,3");
        Assertions.assertThat(sum).isEqualTo(new BigDecimal("6.45"));
    }
}
