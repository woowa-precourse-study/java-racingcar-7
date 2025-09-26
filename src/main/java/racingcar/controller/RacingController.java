package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final RacingService service;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(RacingService service, InputView inputView, OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String inputCarNames = inputView.readCarNames(); // 자동차 이름 입력값 반환
        Cars cars = service.getCars(inputCarNames); // 입력값 검증 + 자동차 리스트 반환

        String inputRaceCount = inputView.readRaceCount(); // 시도할 횟수 입력값 반환
        int raceCount = service.getRaceCount(inputRaceCount); // 입력값 검증 + 양수로 변환한 값 반

        service.runRace(cars, raceCount); // 자동차 경주 진행, 경주 진행 과정은 자동차 리스트에 문자열 형태로 저장됨.
        String winners = service.decideWinners(cars); // 결과에 따른 우승자 선정 후 반환

        outputView.printRace(cars, raceCount); // 자동차 경주 진행 과정 출력
        outputView.printWinners(winners); // 우승자 출력
    }
}
