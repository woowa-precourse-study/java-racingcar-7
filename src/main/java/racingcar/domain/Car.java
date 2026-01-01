package racingcar.domain;

import racingcar.exception.Validator;

public class Car {

    private final String name;
    private int position=0;

    public Car(String name){
        Validator.validateMaxLength(name);
        this.name=name;
    }

    public void movePosition(boolean canMove){
        if (canMove){
            position+=1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
