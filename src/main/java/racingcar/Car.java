package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private String race;
    private int raceCount;

    public Car(String name) {
        this.name = name;
        race = "";
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public int getRaceCount() {
        return raceCount;
    }

    public int pickNumber() {
        return  Randoms.pickNumberInRange(0, 9);
    }

    public void go() {
        race += "-";
        raceCount++;
    }
}
