package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");

        // 1. Input: 다리의 길이를 입력해주세요. (3 ~ 20)
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeLength = Integer.parseInt(Console.readLine());

        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridges = bridgeMaker.makeBridge(bridgeLength);

        // TODO: BridgeGame 생성
        int tryCount = 0;
        int currentPosition = 1;

        while (currentPosition < bridgeLength) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String userMove = Console.readLine();

            if (userMove.equals("U")) {
                // TODO: BridgeGame move("U")
                currentPosition++;
            } else if (userMove.equals("D")) {
                // TODO: BridgeGame move("D")
                currentPosition++;
            } else {
                throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D 만 입력할 수 있습니다.");
            }

            // TODO: 다리 출력

            // 실패한 경우 재시도 여부 검사
            if (false) {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String userRetry = Console.readLine();

                if (userRetry.equals("R")) {
                    tryCount++;
                } else if (userRetry.equals("Q")) {
                    break;
                }
            }
        }

        System.out.println("최종 게임 결과");
        // TODO: 다리 출력
        System.out.println("게임 성공 여부: 성공");
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
