package bridge;

import bridge.helper.InputView;
import bridge.helper.OutputView;

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
            BridgeStatus bridgeStatus = bridgeGame.move(userMoveSelect);

            outputView.printMap(bridgeStatus);

            if (bridgeGame.isFail()) {
                String userRetrySelect = inputView.readGameCommand();
                bridgeGame.retry(userRetrySelect);
            }
        }

        outputView.printResult(bridgeGame);
    }
}
