package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("다리 생성 테스트")
public class BridgeMakerTest {

    @DisplayName("다리의 길이를 입력 받아 U, D 만 포함한 다리를 생성한다")
    @ParameterizedTest
    @MethodSource("bridgeRange")
    void test1(int size) {
        // given
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);;

        // when
        List<String> bridges = bridgeMaker.makeBridge(size);

        // then
        assertThat(bridges.size()).isEqualTo(size);
        assertThat(bridges).containsAnyOf("U", "D");
    }

    @DisplayName("다리의 길이가 3 이상 20 이하가 아니면 실패")
    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void test2(int size) {
        // given
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);;

        // when
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> bridgeMaker.makeBridge(size))
                .withMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    static IntStream bridgeRange() {
        return IntStream.range(3, 20);
    }
}
