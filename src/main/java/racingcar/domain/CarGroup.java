package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private final List<Car> cars = new ArrayList<>();
    private final List<Result> results = new ArrayList<>();

    public void add(Car car){
        validateUniqueName(car);
        cars.add(car);
    }

    public void addResult(Result result){
        results.add(result);
    }

    private void validateUniqueName(Car car) {
        if (cars.contains(car)){
            throw new IllegalArgumentException("[ERROR] 중복된 이름은 사용할 수 없습니다.");
        }
    }

}
