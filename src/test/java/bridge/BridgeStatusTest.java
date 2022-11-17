package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("다리 건너기 게임 상태 테스트")
public class BridgeStatusTest {

    @DisplayName("다리 한칸 건너기 성공 테스트")
    @ParameterizedTest
    @CsvSource({
            "UP, [ O ], [   ]",
            "DOWN, [   ], [ O ]",
    })
    void testMoveSuccess(Move move, String expectedUp, String expectedDown) {
        // given
        BridgeStatus bridgeStatus = new BridgeStatus();

        // when
        bridgeStatus.moveSuccess(move);

        // then
        assertThat(bridgeStatus.getBridgeUp()).isEqualTo(expectedUp);
        assertThat(bridgeStatus.getBridgeDown()).isEqualTo(expectedDown);
    }


    @DisplayName("다리 한칸 건너기 실패 테스트")
    @ParameterizedTest
    @CsvSource({
            "UP, [ X ], [   ]",
            "DOWN, [   ], [ X ]"
    })
    void testMoveFail(Move move, String expectedUp, String expectedDown) {
        // given
        BridgeStatus bridgeStatus = new BridgeStatus();

        // when
        bridgeStatus.moveFail(move);

        // then
        assertThat(bridgeStatus.getBridgeUp()).isEqualTo(expectedUp);
        assertThat(bridgeStatus.getBridgeDown()).isEqualTo(expectedDown);
    }

    @DisplayName("다리 두칸 건너기 성공 테스트")
    @ParameterizedTest
    @CsvSource({
            "UP, UP, [ O | O ], [   |   ]",
            "DOWN, DOWN, [   |   ], [ O | O ]",
            "UP, DOWN, [ O |   ], [   | O ]",
            "DOWN, UP, [   | O ], [ O |   ]"
    })
    void testMoveSuccess2(Move firstMove, Move secondMove, String expectedUp, String expectedDown) {
        // given
        BridgeStatus bridgeStatus = new BridgeStatus();

        // when
        bridgeStatus.moveSuccess(firstMove);
        bridgeStatus.moveSuccess(secondMove);

        // then
        assertThat(bridgeStatus.getBridgeUp()).isEqualTo(expectedUp);
        assertThat(bridgeStatus.getBridgeDown()).isEqualTo(expectedDown);
    }

    @DisplayName("다리 한칸 건너고 다음칸은 실패 테스트")
    @ParameterizedTest
    @CsvSource({
            "UP, UP, [ O | X ], [   |   ]",
            "DOWN, DOWN, [   |   ], [ O | X ]",
            "UP, DOWN, [ O |   ], [   | X ]",
            "DOWN, UP, [   | X ], [ O |   ]"
    })
    void testMoveSuccessAndFail(Move firstMove, Move secondMove, String expectedUp, String expectedDown) {
        // given
        BridgeStatus bridgeStatus = new BridgeStatus();

        // when
        bridgeStatus.moveSuccess(firstMove);
        bridgeStatus.moveFail(secondMove);

        // then
        assertThat(bridgeStatus.getBridgeUp()).isEqualTo(expectedUp);
        assertThat(bridgeStatus.getBridgeDown()).isEqualTo(expectedDown);
    }
}
