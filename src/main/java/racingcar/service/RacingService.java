package racingcar.service;

import racingcar.domain.Car;
import racingcar.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    public List<Car> enrollCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name: names){
            cars.add(new Car(name));
        }
        return cars;
    }

    public void moveCars(List<Car> cars) {
        for (Car car: cars){
            car.movePosition(RandomGenerator.getRandomNumber()>=4);
        }
    }

    public List<String> getWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }


}
