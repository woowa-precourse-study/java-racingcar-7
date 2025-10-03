package racingcar.utils;

import racingcar.exception.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    // 입력값 유효성 검사
    public static void checkBlank(String inputString){
        if (inputString.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_STRING);
        }
    }


    // 입력값 유효성 검사
    public static void checkCarNameLength(List<String> carList){
        for (String carName:carList){
            if (carName.length()>=6){
                throw new IllegalArgumentException(ErrorMessage.TOO_LONG_CAR_NAME);
            }
        }
    }

    // 입력값 유효성 검사
    public static void checkCarNameUnique(List<String> carList){
        Set<String> seen = new HashSet<>();
        for (String carName : carList) {
            if (!seen.add(carName)) {  // add()가 false면 이미 존재
                throw new IllegalArgumentException(ErrorMessage.SAME_CAR_NAME);
            }
        }
    }

    public static void checkTryCount(String inputString){
        try{
            Integer.parseInt(inputString);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY);
        }

    }
}
