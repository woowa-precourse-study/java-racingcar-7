package racingcar.domain;

/*
* position이 가장 먼 사람 찾기
* */

import java.util.ArrayList;
import java.util.List;

public class WinnerCalculator {
    public List<Car> findWinners(List<Car> cars) {
        int maxPosition = 0;
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if(maxPosition < car.getPosition()){
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car);
            }
            else if(maxPosition == car.getPosition()){
                winners.add(car);
            }
        }

        return winners;
    }
}
