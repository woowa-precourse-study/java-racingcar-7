package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private final Map<String,Integer> result = new LinkedHashMap<>();


    public void addCarResult(String name, int position){
        result.put(name,position);
    }
}
