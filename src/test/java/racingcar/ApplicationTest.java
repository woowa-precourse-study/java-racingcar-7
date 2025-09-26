package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.controller.RaceController;
import racingcar.domain.Race;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }
    @Test
    void 입력_예외_테스트_입력값_없음(){
        assertSimpleTest(()->
                assertThatThrownBy(() -> run("",""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_예외_테스트_차량이름_입력(){
        assertSimpleTest(()->
                assertThatThrownBy(() -> run("포비,워니,준","4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_예외_테스트_횟수_입력(){
        assertSimpleTest(()->
                assertThatThrownBy(() -> run("pobi,woni,jun","two"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기능_테스트_컨트롤러_input(){
        RaceController rc = new RaceController();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
