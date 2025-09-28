package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarNameValidator {

    public List<Car> createCarList(String rawStringOfCarNames) {

        List<Car> carList = new ArrayList<>();

        if(rawStringOfCarNames == null || rawStringOfCarNames.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 안 받아요");
        }

        String[] carNamesArray = rawStringOfCarNames.split(",");
        for(String carName : carNamesArray) {
            String trimmed = carName.strip();
            if (trimmed.isBlank()) {
                throw new IllegalArgumentException("[ERROR] 공백은 안 받아요");
            }
            if (trimmed.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 이름이 5자를 초과해요");
            }
            carList.add(new Car(trimmed));
        }

        return carList;
    }

}
