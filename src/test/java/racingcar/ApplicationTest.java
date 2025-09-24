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

    @Test
    void 공동우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,경현,woni", "3");
                    // 두 명의 진행 상태 확인
                    // "최종 우승자 : pobi, woni" 혹은 "최종 우승자 : woni, pobi" 둘 다 허용
                    assertThat(output()).contains("pobi : ---", "경현 : ---", "woni : ---",
                            "최종 우승자 : pobi, 경현, woni");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 쉼표_2개_이상_연속_입력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,,woni", "2");
                    // 두 명의 진행 상태 확인
                    // "최종 우승자 : pobi"
                    assertThat(output()).contains("pobi : --", "woni : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 입력값_양쪽_공백_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("   pobi,woni   ", "1");
                    // 두 명의 진행 상태 확인
                    // "최종 우승자 : pobi"
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차이름_숫자_기호_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi1,$woni", "1");
                    // 두 명의 진행 상태 확인
                    // "최종 우승자 : pobi"
                    assertThat(output()).contains("pobi1 : -", "$woni : ", "최종 우승자 : pobi1");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 입력값_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값_null_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_5자_초과_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_공백포함_5자_초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,kh cho", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차개수_0개_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" , , , ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
