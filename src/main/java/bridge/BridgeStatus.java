package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeStatus {
    public static final String O = " O ";
    public static final String X = " X ";
    public static final String BLANK = "   ";
    public static final String OPENER = "[";
    public static final String CLOSER = "]";
    public static final String DELIMITER = "|";

    public final List<String> ups;
    public final List<String> downs;

    public BridgeStatus() {
        this.ups = new ArrayList<>();
        this.downs = new ArrayList<>();
    }

    public void moveSuccess(Move move) {
        if (move == Move.UP) {
            ups.add(O);
            downs.add(BLANK);
        } else if (move == Move.DOWN) {
            ups.add(BLANK);
            downs.add(O);
        }
    }

    public void moveFail(Move move) {
        if (move == Move.UP) {
            ups.add(X);
            downs.add(BLANK);
        } else if (move == Move.DOWN){
            ups.add(BLANK);
            downs.add(X);
        }
    }

    public String getBridgeUp() {
        return OPENER + String.join(DELIMITER, ups) + CLOSER;
    }

    public String getBridgeDown() {
        return OPENER + String.join(DELIMITER, downs) + CLOSER;
    }
}
