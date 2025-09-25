package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;
    private final List<String> races;

    private Cars(List<Car> cars) {
        this.cars = cars;
        races = new ArrayList<>();
    }

    public static Cars of(String[] inputCarNames) {
        List<Car> cars = Stream.of(inputCarNames)
                .filter(s -> !s.isBlank())
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    public void runRace(int raceCount) {

        for (int i = 0; i < raceCount; i++) {
            cars.stream()
                    .filter(car -> car.pickNumber() >= 4)
                    .forEach(Car::go);

            StringBuilder race = new StringBuilder();
            cars.stream()
                    .map(Car::getRaceResult)
                    .forEach(race::append);

            System.out.println(race.toString());
            races.add(race.toString());
        }
    }

    public String getRace(int i) {
        return races.get(i);
    }

    public int getMaxSteps() {
        Optional<Car> maxCars = cars
                .stream()
                .max(Comparator.comparing(car -> car.raceCount));
        if (maxCars.isEmpty()) {
            throw new IllegalArgumentException(); // 자동차 없음
        }
        return maxCars.get().raceCount;
    }

    public String getWinners(int maxSteps) {
        List<Car> winners = getWinnersList(maxSteps);

        StringBuilder winnersResult = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            String race = winners.get(i).name;
            winnersResult.append(race);
            if (i != winners.size() - 1) {
                winnersResult.append(", ");
            }
        }

        return winnersResult.toString();
    }

    private List<Car> getWinnersList(int maxSteps) {
        return cars.stream()
                .filter(car -> car.raceCount == maxSteps)
                .toList();
    }


    public static class Car {
        private final String name;
        private String race;
        private int raceCount;
        private static final String STEP = "-";

        public Car(String name) {
            this.name = name;
            race = "";
        }

        public String getRaceResult() {
            return name + " : " + race + "\n";
        }

        public int pickNumber() {
            return Randoms.pickNumberInRange(0, 9);
        }

        public void go() {
            race += STEP;
            raceCount++;
        }
    }
}
