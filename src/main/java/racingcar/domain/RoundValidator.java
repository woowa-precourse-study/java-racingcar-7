package racingcar.domain;

public class RoundValidator {

    public int getRound(int rawRound){
        if(rawRound < 0) throw new IllegalArgumentException("[ERROR] 음수는 안 받아요");

        return rawRound;
    }
}
