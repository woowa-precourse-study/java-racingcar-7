package racingcar.domain;

public class RoundValidator {

    public int validateRound(int rawRound){
        if (rawRound < 0) {
            throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
        }
        return rawRound;
    }
}
