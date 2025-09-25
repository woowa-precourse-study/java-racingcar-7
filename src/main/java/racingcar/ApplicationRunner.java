package racingcar;

import racingcar.controller.RacingController;

public class ApplicationRunner {

    public static void run() {
        RacingController controller = new RacingController(
                new racingcar.service.RacingService(),
                new racingcar.view.InputView(),
                new racingcar.view.OutputView()
        );
        controller.run(); // IllegalArgumentException 발생 시 main 에서는 잡지 않음 -> 프로그램 종료
    }
}
