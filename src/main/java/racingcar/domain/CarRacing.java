package racingcar.domain;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class CarRacing {
    private final Cars cars;

    public CarRacing(Cars cars) {
        this.cars = cars;
    }

    public void playRound() {
        List<Car> list = cars.allCars();
        for (Car c : list) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            c.move(randomNum);
        }
    }
    public String[] snapshot() {
        List<Car> list = cars.allCars();
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).render();
        }
        return res;
    }

}
