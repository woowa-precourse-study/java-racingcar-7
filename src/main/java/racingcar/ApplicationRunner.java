package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ApplicationRunner {

    public static void run() {
        // Controller에 생성자 주입
        RacingController controller = new RacingController(
                new RacingService(),
                new InputView(),
                new OutputView()
        );
        controller.run();
    }
}
