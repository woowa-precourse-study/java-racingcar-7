package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

// TODO: split 기능도 추가됨 -> 클래스명 바꾸거나 분리하기
public class CarNameValidator {

    public List<Car> createCarList(String rawStringOfCarNames) {

        List<Car> carList = new ArrayList<>();

        if(rawStringOfCarNames == null || rawStringOfCarNames.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 안 받아요");
        }

        // CarNameVerifier
        // "jenny  "거나 "   "
        String[] carNamesArray = rawStringOfCarNames.split(",");
        for(String carName : carNamesArray) {
            if(carName.isBlank())  throw new IllegalArgumentException("[ERROR] 공백은 안 받아요");
            if(carName.length() > 5) throw new IllegalArgumentException("[ERROR] 이름이 5자를 초과해");
            carList.add(new Car(carName.strip()));
        }

        return carList;
    }

}
