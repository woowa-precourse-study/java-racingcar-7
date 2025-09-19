package racingcar.view;

import java.util.List;

public class OutputView {

    public void printHeader() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printSnapshots(String[][] snapshots) {
        for (String[] round : snapshots) {
            for (String line : round) {
                System.out.println(line);
            }
            System.out.println();
        }
    }

    public void printWinners(List<String> winners) {
        if (winners == null || winners.isEmpty()) return;
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
