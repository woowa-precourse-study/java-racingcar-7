package racingcar.domain;

public class Cars {

  private Car[] cars;

  public Cars(String[] carNames) {
    this.cars = new Car[carNames.length];
    for (int i = 0; i < carNames.length; i++) {
      cars[i] = new Car(carNames[i],0);
    }
  }

  public Car[] getCars(){
    return cars;
  }

}
