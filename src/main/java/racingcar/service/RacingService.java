package racingcar.service;

import racingcar.domain.Cars;

import java.util.List;

import static racingcar.util.ParseInt.parseInt;
import static racingcar.util.Split.split;
import static racingcar.util.Validator.*;

public class RacingService {
    public Cars getCars(String inputCarNames) {
        validateBlank(inputCarNames);

        List<String> splitCarNames = split(inputCarNames);

        validateLength(splitCarNames);
        validateNoCars(splitCarNames);

        return Cars.of(splitCarNames);
    }

    public int getRaceCount(String inputRaceCount) {
        validateBlank(inputRaceCount);

        int raceCount = parseInt(inputRaceCount);

        validateOverflow(inputRaceCount, raceCount);

        return raceCount;
    }

    public void runRace(Cars cars, int raceCount) {
        cars.runRace(raceCount);
    }

    public String decideWinners(Cars cars) {
        int winnerSteps = cars.getWinnerSteps();

        return cars.getWinners(winnerSteps);
    }
}
