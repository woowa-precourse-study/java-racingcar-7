package racingcar;
import racingcar.controller.CarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;


public class Application {

    public static void main(String[] args) {
        InputView in = new InputView();
        OutputView out = new OutputView();
        CarController ctrl = new CarController();


        String rawNames = in.readCarNames();
        int attempts = in.readAttempts();

        List<String> names = ctrl.parseNames(rawNames);
        out.printHeader();

        String[][] snapshots = ctrl.run(names, attempts);
        out.printSnapshots(snapshots);

        List<String> winners = ctrl.findWinners(snapshots, names);
        out.printWinners(winners);
    }
}
