package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    private static final String RESULT_MSG = "최종 우승자 : ";
    
    public void printResult(List<Car> winners) {
        StringBuilder resultString = new StringBuilder(RESULT_MSG);

        // 람다로 써보기
        for(int i=0; i<winners.size() - 1; i++) {
            resultString.append(winners.get(i).getCarName()).append(", ");
        }
        resultString.append(winners.get(winners.size() - 1).getCarName());

        System.out.println(resultString);
    }
}
