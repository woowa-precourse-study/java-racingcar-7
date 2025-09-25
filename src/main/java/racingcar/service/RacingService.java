package racingcar.service;

import racingcar.domain.Cars.Car;
import racingcar.domain.Cars;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static racingcar.util.ParseInt.parseInt;
import static racingcar.util.Validator.*;

public class RacingService {

    public Cars startRace(String inputCarNames, int raceCount) {
        validateNull(inputCarNames);

        String[] splitCarNames = inputCarNames.split(",");
        validateLength(splitCarNames);
        Cars cars = Cars.of(splitCarNames);

        cars.runRace(raceCount);

        return cars;
    }

    public int getRaceCount(String inputRaceCount) {
        validateNull(inputRaceCount);
        return parseInt(inputRaceCount);
    }

    public String decideWinners(Cars cars) {
        int maxSteps = cars.getMaxSteps();

        return cars.getWinners(maxSteps);
    }
}
