package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    // Service 메인 함수
    public void doRace(List<Car> carList){

        for(Car car:carList){
            // 랜덤 수 뽑기
            Integer randomNumber=getRandomNumber();

            //Car 객체의 position 갱신
            car.move(randomNumber);

            // 출력하기
            System.out.println(printRaceResult(car.getName(),car.getPosition()));

            // record에 저장

        }

    }

    // 랜덤 수 뽑기
    public int getRandomNumber(){
        int randomNumber=Randoms.pickNumberInRange(0,9);
        return randomNumber;
    }

    // 자동차의 랜덤 수 출력할 문자열 만들기
    public String printRaceResult(String name, int number){
        if (number==0){
            return name + " : ";
        }
        return name + " : "+"-".repeat(number);
    }


    // 우승자 판별
    public List<String> getWinners(List<Car> cars){
        // 1. 최대 position 찾기
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        // 2. 최대 position과 같은 자동차들 이름 수집
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

    }

}
