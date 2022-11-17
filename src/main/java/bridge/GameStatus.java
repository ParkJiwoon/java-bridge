package bridge;

public enum GameStatus {
    PLAYING("진행"),
    SUCCESS("성공"),
    FAIL("실패")
    ;

    private final String korean;

    GameStatus(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }
}
