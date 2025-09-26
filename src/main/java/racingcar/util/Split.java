package racingcar.util;

import java.util.List;
import java.util.stream.Stream;

public class Split {

    private static final String DELIMITER = ","; // 구분자

    public static List<String> split(String str) {
        // 각 자동차 이름의 양쪽 공백을 제거 한 후 이름을 저장하는 리스트 생성 후 반환
        return Stream.of(str.split(DELIMITER)).map(String::strip).toList();
    }
}
