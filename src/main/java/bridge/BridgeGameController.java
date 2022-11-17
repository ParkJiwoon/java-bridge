package bridge;

import bridge.helper.InputView;
import bridge.helper.OutputView;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gamePlay() {
        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = newBridgeGame(bridgeSize);

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

    private BridgeGame newBridgeGame(int bridgeSize) {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridges = bridgeMaker.makeBridge(bridgeSize);
        return new BridgeGame(bridges);
    }
}
