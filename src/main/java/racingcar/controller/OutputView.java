package racingcar.controller;


import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void printResult(){
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(List<Car> cars){
        for (Car car:cars){
            System.out.println(String.format("%s : %s",car.getName(),"-".repeat(car.getPosition())));
        }
    }
}

