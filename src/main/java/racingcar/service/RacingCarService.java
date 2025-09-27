package racingcar.service;

/*
* 입력 검증(CarNameVerifier, RoundVerifier)
CarNameVerifier:
예외: strip → 이름.length() > 5
예외: isblank
RoundVerifier:
예외: 숫자가 아닌 값이 들어올 때
예외: 음수일 때
Car 생성
‘실행 결과' 출력 - 이거 Racing에 들어있으면 좋겠는데
Racing - 여기도 좀 리팩토링 하고 싶은데
round만큼 반복
RandomMover
라운드 별 실행 결과 출력
WinnersFinder
*/

import racingcar.domain.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    // public static final String PLAY_MSG = "실행 결과";

    public static final CarNameValidator carNameValidator = new CarNameValidator();
    public static final RoundValidator roundValidator = new RoundValidator();
    public static final WinnerCalculator winnerCalculator = new WinnerCalculator();

    private final Mover mover = new RandomMover();

    public List<List<Car>> startRace(String rawCarNames, int rawRound) {
        List<Car> carList = carNameValidator.createCarList(rawCarNames);
        int round = roundValidator.validateRound(rawRound);

        List<List<Car>> raceHistory = new ArrayList<>();

        for (int i = 0; i < round; i++) {
            for (Car car : carList) {
                car.moveIfPossible(mover);
            }
            // 현재 라운드 snapshot 저장
            raceHistory.add(cloneCars(carList));
        }

        return raceHistory;
    }

    public List<Car> getWinners(List<List<Car>> raceHistory) {
        List<Car> lastRound = raceHistory.get(raceHistory.size() - 1);
        return winnerCalculator.calculate(lastRound);
    }

    private List<Car> cloneCars(List<Car> cars) {
        List<Car> snapshot = new ArrayList<>();
        for (Car car : cars) {
            snapshot.add(new Car(car.getCarName(), car.getPosition()));
        }
        return snapshot;
    }
}
