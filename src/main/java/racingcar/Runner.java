package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;

public class Runner {
    public void run(RacingService racingService){
        RacingController racingController=new RacingController(racingService);
        racingController.playGame();
    }

}
