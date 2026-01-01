package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;

public class Application {
    public static void main(String[] args) {
        RacingService service = new RacingService();
        RacingController controller = new RacingController(service);
        try {
            controller.run();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
