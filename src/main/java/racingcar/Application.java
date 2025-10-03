package racingcar;

import racingcar.service.RacingService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Runner runner=new Runner();
        RacingService racingService=new RacingService();
        runner.run(racingService);

    }
}
