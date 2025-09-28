package racingcar.service;

import racingcar.domain.*;
import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    public static final CarNameValidator carNameValidator = new CarNameValidator();
    public static final RoundValidator roundValidator = new RoundValidator();
    public static final WinnerCalculator winnerCalculator = new WinnerCalculator();

    private final Mover mover = new RandomMover();

    public List<List<Car>> startRace(String rawCarNames, int rawRound) {
        List<Car> carList = carNameValidator.createCarList(rawCarNames);
        int round = roundValidator.validateRound(rawRound);

        List<List<Car>> raceHistory = new ArrayList<>();

        for (int i = 0; i < round; i++) {
            for (Car car : carList) {
                car.moveIfPossible(mover);
            }
            // 현재 라운드 snapshot 저장
            raceHistory.add(cloneCars(carList));
        }

        return raceHistory;
    }

    public List<Car> getWinners(List<List<Car>> raceHistory) {
        List<Car> lastRound = raceHistory.get(raceHistory.size() - 1);
        return winnerCalculator.calculate(lastRound);
    }

    private List<Car> cloneCars(List<Car> cars) {
        List<Car> snapshot = new ArrayList<>();
        for (Car car : cars) {
            snapshot.add(new Car(car.getCarName(), car.getPosition()));
        }
        return snapshot;
    }
}
