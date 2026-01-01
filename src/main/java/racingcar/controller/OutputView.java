package racingcar.controller;


import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void printResult(){
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(List<Car> cars){
        for (Car car:cars){
            System.out.printf("%s : %s\n",car.getName(),"-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinnerResult(List<String> winners){
        System.out.printf("최종 우승자 : %s\n", String.join(", ",winners));
    }
}

