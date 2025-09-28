package racingcar.domain;

public class Car {
    private final String carName; // carName은 불변이니까
    private int position;

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void moveIfPossible(Mover mover) {
        if (mover.canMove()) {
            position++;
        }
    }
}
