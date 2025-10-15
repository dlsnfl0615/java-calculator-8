package calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {
    @Test
    @DisplayName("숫자가 아닌 문자 입력")
    void add_with_character_number() {
        Validator validator = new Validator();
        String input = "x";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateAndParse(input);
        });
    }

    @Test
    @DisplayName("음수 입력")
    void add_with_negative_number() {
        Validator validator = new Validator();
        String input = "-1";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateAndParse(input);
        });
    }

    @Test
    @DisplayName("자연수 입력")
    void add_with_natural_number() {
        Validator validator = new Validator();
        String input = "10000";
        BigDecimal result = validator.validateAndParse(input);
        assertThat(result).isEqualTo(new BigDecimal(10000));
    }

    @Test
    @DisplayName("실수 입력")
    void add_with_real_number() {
        Validator validator = new Validator();
        String input = "3.141592";
        BigDecimal result = validator.validateAndParse(input);
        assertThat(result).isEqualTo(new BigDecimal("3.141592"));
    }
}
