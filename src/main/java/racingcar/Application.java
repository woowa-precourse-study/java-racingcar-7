package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input1 = Console.readLine().strip(); // 앞뒤 공백 제거
        if (input1 == null || input1.isBlank()) {
            throw new IllegalArgumentException();
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String input2 = Console.readLine().strip();
        int count;
        try {
            count = Integer.parseUnsignedInt(input2);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }


        String[] carNames = input1.split(",");
        List<String> list1 = Stream.of(carNames)
                .filter(s -> !s.isBlank())
                .filter(s -> s.length() > 5)
                .toList();
        if (!list1.isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<String> list2 = Stream.of(carNames).filter(s -> !s.isBlank()).toList();
        List<Car> cars = new ArrayList<>();
        for (String s : list2) {
            cars.add(new Car(s));
        }

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                if (car.pickNumber() >= 4) {
                    car.go();
                }
            }

            for (Car car : cars) {
                System.out.println(car.getName() + " : " + car.getRace());
            }

            System.out.println();
        }

        Optional<Car> maxCars = cars.stream().max(Comparator.comparing(Car::getRaceCount));
        if (maxCars.isEmpty()) {
            throw new IllegalArgumentException(); // 자동차 없음
        }
        int max = maxCars.get().getRaceCount();

        List<Car> winners = cars.stream().
                filter(car -> car.getRaceCount() == max)
                .toList();

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
