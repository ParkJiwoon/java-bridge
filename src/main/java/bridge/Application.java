package bridge;

import bridge.helper.InputValidator;
import bridge.helper.InputView;
import bridge.helper.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            InputValidator inputValidator = new InputValidator();
            InputView inputView = new InputView(inputValidator);
            OutputView outputView = new OutputView();

            BridgeGameController bridgeGameController = new BridgeGameController(inputView, outputView);
            bridgeGameController.gamePlay();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
