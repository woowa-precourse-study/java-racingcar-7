package racingcar.controller;


import racingcar.domain.Result;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printResult(List<Result> results){
        System.out.println("실행 결과");
        for (Result result : results){
            Map<String,Integer> result1= result.getResult();
            for (String name:result1.keySet()){
                System.out.printf("%s : %s\n",name,"-".repeat(result1.get(name)));
            }
            System.out.println();
        }
    }

    public static void printWinner(List<String> winners){
        System.out.printf("최종 우승자 : %s",String.join(", ",winners));
    }
}
