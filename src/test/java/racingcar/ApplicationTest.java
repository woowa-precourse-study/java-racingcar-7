package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
//여러번 실행했을떄 결과 나와야함
    @Test
    void 기능_테스트_여러번() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains("pobi : -----", "woni : ----","jun : -----", "최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP,MOVING_FORWARD
        );
    }


    /**
     * 자동차 예외 테스트
     * - 이름이 6글자 이상일 경우
     * - 빈 문자열 입력한 경우
     * - 같은 이름을 입력한 경우
     */

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Test
    void 예외_테스트_같은이름자동차() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_빈문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    /**
     * 시도 횟수 예외 테스트
     * - 시도 횟수 형식이 숫자가 아닌 경우
     * - 빈 문자열일 경우
     */

    @Test
    void 예외_테스트_시도횟수형식() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javi", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수_빈문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javi", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
