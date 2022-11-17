package bridge;

import bridge.helper.InputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int bridgeSize = inputView.readBridgeSize();

        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridges = bridgeMaker.makeBridge(bridgeSize);

        BridgeGame bridgeGame = new BridgeGame(bridges);

        while (bridgeGame.isPlaying()) {
            String userMoveSelect = inputView.readMoving();
            bridgeGame.move(userMoveSelect);

            // TODO: 다리 출력

            // 실패한 경우 재시도 여부 검사
            if (bridgeGame.isFail()) {
                String userRetrySelect = inputView.readGameCommand();
                bridgeGame.retry(userRetrySelect);
            }
        }

        System.out.println("최종 게임 결과");
        // TODO: 다리 출력
        System.out.println("게임 성공 여부: 성공");
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }
}
