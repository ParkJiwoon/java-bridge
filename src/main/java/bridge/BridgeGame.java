package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static final int INIT_TRY_COUNT = 1;
    private final List<String> bridges;
    private BridgeStatus bridgeStatus;
    private GameStatus gameStatus;
    private int tryCount;
    private int currentPosition;

    public BridgeGame(List<String> bridges) {
        this.bridges = new ArrayList<>(bridges);
        init(INIT_TRY_COUNT);
    }

    public void init(int tryCount) {
        this.tryCount = tryCount;
        this.bridgeStatus = new BridgeStatus();
        this.currentPosition = 0;
        this.gameStatus = GameStatus.PLAYING;
    }

    public BridgeStatus getBridgeStatus() {
        return bridgeStatus;
    }

    public String getResult() {
        return gameStatus.getKorean();
    }

    public int getTryCount() {
        return tryCount;
    }

    public void incrementCurrentPosition() {
        currentPosition += 1;

        if (currentPosition == bridges.size()) {
            gameStatus = GameStatus.SUCCESS;
        }
    }

    public boolean isPlaying() {
        return gameStatus == GameStatus.PLAYING;
    }

    public boolean isFail() {
        return gameStatus == GameStatus.FAIL;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeStatus move(String userMoveSelect) {
        Move move = Move.valueOfSelect(userMoveSelect);
        String nextSpace = bridges.get(currentPosition);

        if (nextSpace.equals(userMoveSelect)) {
            return moveSuccess(move);
        }

        return moveFail(move);
    }

    private BridgeStatus moveSuccess(Move move) {
        incrementCurrentPosition();
        bridgeStatus.moveSuccess(move);
        return bridgeStatus;
    }

    private BridgeStatus moveFail(Move move) {
        gameStatus = GameStatus.FAIL;
        bridgeStatus.moveFail(move);
        return bridgeStatus;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String userRetrySelect) {
        if (userRetrySelect.equals("R")) {
            init(tryCount + 1);
        }
    }
}
