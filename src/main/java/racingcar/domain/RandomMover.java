package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMover implements Mover {
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD;
    }
}
