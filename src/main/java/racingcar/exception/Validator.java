package racingcar.exception;

import racingcar.utils.Parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface Validator {
    void validate(String input);


    static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 값은 입력할 수 없습니다.");
        }
    }

    static void validateNameIsUnique(String input){
        List<String> inputs = Parser.splitBy(input,",");
        Set<String> nameSet = new HashSet<>(inputs);
        if (nameSet.size() != inputs.size()){
            throw new IllegalArgumentException("[ERROR] 이름은 중복될 수 없습니다.");
        }
    }

    static void validateMaxLength(String input) {
        int maxLength = 5;
        if (input.length() > maxLength) {
            throw new IllegalArgumentException("[ERROR] 입력 길이는 " + maxLength + "자를 초과할 수 없습니다.");
        }
    }

}

