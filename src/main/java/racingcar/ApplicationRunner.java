package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ApplicationRunner {

    public static void run() {
        RacingController controller = new RacingController(
                new RacingService(),
                new InputView(),
                new OutputView()
        );
        controller.run();
    }
}
