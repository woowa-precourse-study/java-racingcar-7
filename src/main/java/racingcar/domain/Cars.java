package racingcar.domain;
import java.util.*;


public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        for (String n : names) {
            cars.add(new Car(n));
        }
    }

    public List<Car> allCars() { return cars; }
    public int size() { return cars.size(); }


}
