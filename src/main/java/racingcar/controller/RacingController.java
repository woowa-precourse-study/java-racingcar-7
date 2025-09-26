package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorMessage;
import racingcar.service.RacingService;

public class RacingController {


    private final RacingService racingService;

    public RacingController(RacingService racingService){
        this.racingService=racingService;
    }

    // 컨트롤러 메인 함수
    public void playGame(){
        printMessage(PrintMessage.REQUEST_CAR_NAME);
        String carString=getInput();
        checkBlank(carString);

        printMessage(PrintMessage.REQUEST_TRY_COUNT);
        String tryString=getInput();
        checkBlank(tryString);


    }

    // 입력 요청 메세지
    public void printMessage(String message){
        System.out.print(message);
    }

    // 입력 받음
    public String getInput(){
        String inputString=Console.readLine();
        return inputString;
    }

    // 입력값 유효성 검사
    public Boolean checkBlank(String inputString){
        if (inputString.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_STRING);
        }
        return true;
    }


}
