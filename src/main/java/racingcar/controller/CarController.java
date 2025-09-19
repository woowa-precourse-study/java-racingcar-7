package racingcar.controller;

import racingcar.domain.CarRacing;
import racingcar.domain.Cars;

import java.util.*;
import java.util.stream.Collectors;

public class CarController {

    public List<String> parseNames(String raw) {
        return Arrays.stream(raw.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    public String[][] run(List<String> names, int attempts) {
        Cars cars = new Cars(names);
        CarRacing racing = new CarRacing(cars);

        String[][] snapshots = new String[attempts][cars.size()];
        for (int r = 0; r < attempts; r++) {
            racing.playRound();
            snapshots[r] = racing.snapshot();
        }
        return snapshots;
    }

    public List<String> findWinners(String[][] snapshots, List<String> names) {
        if (snapshots.length == 0) return Collections.emptyList();
        String[] last = snapshots[snapshots.length - 1];

        int[] pos = new int[last.length];
        for (int i = 0; i < last.length; i++) {
            int dash = 0;
            for (int k = last[i].length() - 1; k >= 0 && last[i].charAt(k) == '-'; k--) dash++;
            pos[i] = dash;
        }

        int max = Arrays.stream(pos).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] == max) winners.add(names.get(i));
        }
        return winners;
    }

}
