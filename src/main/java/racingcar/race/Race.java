package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class Race {

  public HashMap<String, Integer> setCarInfo(String[] cars) {
    HashMap<String, Integer> carInfo = new HashMap<>();
    for (String car : cars) {
      carInfo.put(car, 0);
    }
    return carInfo;
  }

  public void startRace(int tryNumberInt, String[] cars, HashMap<String, Integer> carInfo) {
    while(tryNumberInt > 0) {
      for(String car : cars){
        int currentPosition = carInfo.get(car);
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if(randomNumber >=4) {
          currentPosition++;
          carInfo.put(car,currentPosition);
        }
        System.out.println(car + " : " +  "-".repeat(currentPosition));
      }
      System.out.println();
      tryNumberInt--;
    }
  }
}
