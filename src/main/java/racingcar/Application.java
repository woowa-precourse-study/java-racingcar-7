package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingService racingService=new RacingService();
        RacingController racingController=new RacingController(racingService);
        racingController.playGame();

    }
}
