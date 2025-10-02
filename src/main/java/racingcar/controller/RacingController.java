package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.build.Plugin;
import racingcar.domain.Car;
import racingcar.exception.ErrorMessage;
import racingcar.service.RacingService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService){
        this.racingService=racingService;
    }

    // 컨트롤러 메인 함수
    public void playGame(){
        // 자동차 이름 입력 요청
        printMessage(PrintMessage.REQUEST_CAR_NAME);
        String carString=getInput();
        checkBlank(carString);
        List<String> carNameList=splitCarList(carString);
        checkCarNameLength(carNameList);
        checkCarNameUnique(carNameList);

        // 시도 횟수 입력 요청
        printMessage(PrintMessage.REQUEST_TRY_COUNT);
        String tryString=getInput();
        checkBlank(tryString);
        checkTryCount(tryString);

        // 결과 출력
        printMessage(PrintMessage.RACING_RESULT_TITLE);

        // 자동차 객체 생성
        int tryCount=Integer.parseInt(tryString);
        List<Car> cars=carNameList.stream()
                                .map(Car::new)
                                .toList();

        // 레이스
        for(int i=0;i<tryCount;i++){
            racingService.doRace(cars);
        }

        // 우승자 출력
        List<String> winners=racingService.getWinners(cars);
        printMessage(PrintMessage.RACING_RESULT_WINNER + String.join(", ",  winners));


    }

    // 입력 요청 메세지
    public void printMessage(String message){
        System.out.println(message);
    }

    // 입력 받음
    public String getInput(){
        String inputString=Console.readLine();
        return inputString;
    }

    // 입력값 유효성 검사
    public void checkBlank(String inputString){
        if (inputString.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_STRING);
        }
    }

    // 자동차 입력값 가공
    public List<String> splitCarList(String inputString){
        List<String> carList=List.of(inputString.split(","));
        return carList;
    }

    // 입력값 유효성 검사
    public void checkCarNameLength(List<String> carList){
        for (String carName:carList){
            if (carName.length()>=6){
                throw new IllegalArgumentException(ErrorMessage.TOO_LONG_CAR_NAME);
            }
        }
    }

    // 입력값 유효성 검사
    public void checkCarNameUnique(List<String> carList){
        Set<String> seen = new HashSet<>();
        for (String carName : carList) {
            if (!seen.add(carName)) {  // add()가 false면 이미 존재
                throw new IllegalArgumentException(ErrorMessage.SAME_CAR_NAME);
            }
        }
    }

    public void checkTryCount(String inputString){
        try{
            Integer.parseInt(inputString);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY);
        }

    }

}
