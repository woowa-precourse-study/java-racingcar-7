package racingcar.service;

import racingcar.domain.Cars;

import java.util.List;

import static racingcar.util.ParseInt.parseInt;
import static racingcar.util.Split.split;
import static racingcar.util.Validator.*;

public class RacingService {
    public Cars getCars(String inputCarNames) {
        validateBlank(inputCarNames); // 입력값이 빈 문자열이 아닌지 검증

        List<String> splitCarNames = split(inputCarNames); // 입력값을 쉼표(,)로 구분해 자동차 이름을 저장하는 리스트로 생성

        validateLength(splitCarNames); // 각 자동차 이름의 길이가 5를 초과하지 않는지 검증
        validateNoCars(splitCarNames); // 유효한 자동차 이름이 1개 이상인지 검증

        return Cars.of(splitCarNames); // 자동차 리스트 생성 및 반환
    }

    public int getRaceCount(String inputRaceCount) {
        validateBlank(inputRaceCount); // 입력값이 빈 문자열이 아닌지 검증

        int raceCount = parseInt(inputRaceCount); // 입력값을 양수로 변환, 불가능할 시 예외 발생

        validateOverflow(inputRaceCount, raceCount); // 정수 오버플로우 검증

        return raceCount;
    }

    public void runRace(Cars cars, int raceCount) {
        cars.runRace(raceCount); // 자동차 경주 진행
    }

    public String decideWinners(Cars cars) {
        int winnerSteps = cars.getWinnerSteps(); // 우승자 step 개수 반환

        return cars.getWinners(winnerSteps); // 우승자 출력 문자열 반환
    }
}
