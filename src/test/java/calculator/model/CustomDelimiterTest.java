package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomDelimiterTest {
    @Test
    @DisplayName("하나의 문자를 가지는 커스텀 구분자")
    void add_with_single_char_delimiter() {
        CustomDelimiter delimiter = new CustomDelimiter();
        String[] result = delimiter.separate("//a\n1,2.3a4");
        String customDelimiter = result[0];
        String numbers = result[1];
        Assertions.assertThat(customDelimiter).isEqualTo("a|,|:");
        Assertions.assertThat(numbers).isEqualTo("1,2.3a4");
    }

    @Test
    @DisplayName("여러개의 문자를 가지는 커스텀 구분자")
    void add_with_plural_char_delimiter() {
        CustomDelimiter delimiter = new CustomDelimiter();
        String[] result = delimiter.separate("//asdf\n1,2:3asdf4");
        String customDelimiter = result[0];
        String numbers = result[1];
        Assertions.assertThat(customDelimiter).isEqualTo("asdf|,|:");
        Assertions.assertThat(numbers).isEqualTo("1,2:3asdf4");
    }

    @Test
    @DisplayName("커스텀 구분자가 슬래시")
    void add_with_slash_delimiter() {
        CustomDelimiter delimiter = new CustomDelimiter();
        String[] result = delimiter.separate("///\n1,2:3/4");
        String customDelimiter = result[0];
        String numbers = result[1];
        Assertions.assertThat(customDelimiter).isEqualTo("/|,|:");
        Assertions.assertThat(numbers).isEqualTo("1,2:3/4");
    }

    @Test
    @DisplayName("커스텀 구분자가 역슬래시")
    void add_with_backslash_delimiter() {
        CustomDelimiter delimiter = new CustomDelimiter();
        String[] result = delimiter.separate("//\\\n1,2:3\\4");
        String customDelimiter = result[0];
        String numbers = result[1];
        Assertions.assertThat(customDelimiter).isEqualTo("\\|,|:");
        Assertions.assertThat(numbers).isEqualTo("1,2:3\\4");
    }

    @Test
    @DisplayName("두 개의 슬래시가 아니라 하나의 슬래시로 시작")
    void start_with_single_slash() {
        CustomDelimiter delimiter = new CustomDelimiter();
        assertThrows(IllegalArgumentException.class, () -> {
            String[] result = delimiter.separate("/asdf\n1,2:3");
        });
    }

    @Test
    @DisplayName("커스텀 구분자가 비어있음")
    void add_with_blank_delimiter() {
        CustomDelimiter delimiter = new CustomDelimiter();
        assertThrows(IllegalArgumentException.class, () -> {
            String[] result = delimiter.separate("//\n1,2:3");
        });
    }

    @Test
    @DisplayName("슬래시로 시작하지 않는데 \\n가 입력됨")
    void contain_enter() {
        CustomDelimiter delimiter = new CustomDelimiter();
        assertThrows(IllegalArgumentException.class, () -> {
            String[] result = delimiter.separate("\n1,2:3");
        });
    }

    @Test
    @DisplayName("\\n가 없음")
    void without_enter() {
        CustomDelimiter delimiter = new CustomDelimiter();
        assertThrows(IllegalArgumentException.class, () -> {
            String[] result = delimiter.separate("//a1,2:3");
        });
    }

    @Test
    @DisplayName("커스텀 구분자로 마침표가 입력된 경우")
    void dot_delimiter() {
        CustomDelimiter delimiter = new CustomDelimiter();
        assertThrows(IllegalArgumentException.class, () -> {
            String[] result = delimiter.separate("//.\n1,2:3.4");
        });
    }
}
