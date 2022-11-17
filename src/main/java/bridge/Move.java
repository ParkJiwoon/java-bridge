package bridge;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Move {
    UP("U"),
    DOWN("D")
    ;

    private final String select;

    Move(String select) {
        this.select = select;
    }

    private String getSelect() {
        return select;
    }

    private static final Map<String, Move> BY_SELECT =
            Stream.of(values()).collect(Collectors.toMap(Move::getSelect, e -> e));

    public static Move valueOfSelect(String select) {
        Move move = BY_SELECT.get(select);

        if (move == null) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D 만 입력할 수 있습니다.");
        }

        return BY_SELECT.get(select);
    }
}
