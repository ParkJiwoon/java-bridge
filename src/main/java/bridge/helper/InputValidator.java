package bridge.helper;

import java.util.Set;

public class InputValidator {

    public static void validateNumberType(String input) {
        boolean isNumber = input.chars().allMatch(Character::isDigit);

        if (!isNumber) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    public static void validateMove(String input) {
        if (!Set.of("U", "D").contains(input)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D 만 입력할 수 있습니다.");
        }
    }

    public static void validateRetryOrQuit(String input) {
        if (!Set.of("R", "Q").contains(input)) {
            throw new IllegalArgumentException("[ERROR] 재시도 선택은 R 또는 Q 만 입력할 수 있습니다.");
        }
    }
}
