package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter {
    // 기본 구분자: 쉼표 또는 콜론
    private static final String DEFAULT_DELIMITER = ",|:";
    // 커스텀 구분자 패턴: "//(.)\n(.*)"
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.+)\n(.*)");

    // 입력 문자열에서 [구분자, 숫자부분] 배열을 추출하여 반환
    public String[] separate(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        boolean isPerfectMatch = matcher.find();

        // 커스텀 구분자 사용을 위해 슬래시와 엔터를 입력했지만 올바른 양식이 아닌 경우
        boolean hasAttemptSigns = text.startsWith("/") || text.contains("\n");
        if (hasAttemptSigns && !isPerfectMatch) {
            throw new IllegalArgumentException("커스텀 구분자 형식 오류: '//[구분자]\\n[숫자]' 형식이어야 합니다.");
        }

        // 올바른 양식이지만 커스텀 구분자로 마침표를 사용한 경우
        if (isPerfectMatch && matcher.group(1).equals(".")) {
            throw new IllegalArgumentException("커스텀 구분자 형식 오류: 커스텀 구분자로 마침표를 사용할 수 없습니다.");
        }

        // 올바른 커스텀 구분자인 경우
        if (isPerfectMatch) {
            String customDelimiter = matcher.group(1);
            // 역슬래시가 입력된 경우 이스케이프 처리하지 않고 문자 그대로 입력받기 위해서
            String quotedCustomDelimiter = Pattern.quote(customDelimiter);
            String delimiters = quotedCustomDelimiter + "|" + DEFAULT_DELIMITER;
            return new String[]{delimiters, matcher.group(2)};
        }

        // 기본 구분자를 사용한 경우
        return new String[]{DEFAULT_DELIMITER, text};
    }
}