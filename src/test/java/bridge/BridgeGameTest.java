package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("다리 건너기 게임 테스트")
public class BridgeGameTest {

    @Test
    @DisplayName("윗칸으로 이동하기 성공, 성공")
    void test1() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "U"));

        // 1. 윗칸으로 이동하기 - 성공
        BridgeStatus bridgeStatus1 = bridgeGame.move("U");
        assertThat(bridgeStatus1.getBridgeUp()).isEqualTo("[ O ]");
        assertThat(bridgeStatus1.getBridgeDown()).isEqualTo("[   ]");

        // 2. 윗칸으로 이동하기 - 성공
        BridgeStatus bridgeStatus2 = bridgeGame.move("U");
        assertThat(bridgeStatus2.getBridgeUp()).isEqualTo("[ O | O ]");
        assertThat(bridgeStatus2.getBridgeDown()).isEqualTo("[   |   ]");
    }

    @Test
    @DisplayName("윗칸으로 이동하기 성공, 실패")
    void test2() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "U"));

        // 1. 윗칸으로 이동하기 - 성공
        BridgeStatus bridgeStatus1 = bridgeGame.move("U");
        assertThat(bridgeStatus1.getBridgeUp()).isEqualTo("[ O ]");
        assertThat(bridgeStatus1.getBridgeDown()).isEqualTo("[   ]");

        // 2. 아랫칸으로 이동하기 - 실패
        BridgeStatus bridgeStatus2 = bridgeGame.move("D");
        assertThat(bridgeStatus2.getBridgeUp()).isEqualTo("[ O |   ]");
        assertThat(bridgeStatus2.getBridgeDown()).isEqualTo("[   | X ]");
    }
}
