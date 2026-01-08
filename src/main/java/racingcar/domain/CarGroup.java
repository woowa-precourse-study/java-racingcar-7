package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
    private final List<Car> cars = new ArrayList<>();
    private final List<Result> results = new ArrayList<>();

    public void add(Car car) {
        validateUniqueName(car);
        cars.add(car);
    }

    public void addResult(Result result) {
        results.add(result);
    }

    public void playGame() {
        Result result = new Result();
        for (Car car : cars) {
            int randomNum = RandomGenerator.getRandomNumber();
            car.move(randomNum);
            result.addCarResult(car.getName(), car.getPosition());
        }
        addResult(result);
    }

    public List<Result> getResults() {
        return results;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private void validateUniqueName(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름은 사용할 수 없습니다.");
        }
    }

}
