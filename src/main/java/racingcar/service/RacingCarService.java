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

import racingcar.domain.Car;
import racingcar.domain.CarNameVerifier;
import racingcar.domain.RoundVerifier;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.WinnersFinder;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    public static final String PLAY_MSG = "실행 결과";

    public static final CarNameVerifier carNameVerifier = new CarNameVerifier();
    public static final RoundVerifier roundVerifier = new RoundVerifier();
    public static final WinnersFinder winnersFinder = new WinnersFinder();

    public List<Car> playRacingCar(String rawCarNames, int rawRound) {
        // CarNameVerifier
        List<Car> carList =  carNameVerifier.createCarList(rawCarNames);

        // RoundVerifier
        int round = roundVerifier.getRound(rawRound);

        System.out.println(PLAY_MSG);
        // Racing -> RandomMover
        for(int i=0; i<round; i++){
            for(Car currentCar : carList){
                if(Randoms.pickNumberInRange(0,9) >= 4){
                    currentCar.move();
                }
                System.out.print(currentCar.getCarName()+" : ");

                for(int j=0; j<currentCar.getPosition(); j++){
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        return winnersFinder.findWinners(carList);
    }
}
