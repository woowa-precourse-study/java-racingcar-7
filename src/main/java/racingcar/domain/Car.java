package racingcar.domain;

public class Car {
    private final String name;  // 자동차 이름
    private int position;          // 자동차 현재 위치

    public Car(String name){
        this.name=name;
        this.position=0;
    }

//    // 정적 메서드 팩토리
//    public static Car carCreate(String name){
//        return new Car(name);
//    }

    // 현재 위치를 갱신하는 메서드
    public void move(int randomNumber){
        if (randomNumber>=4){
            position=position+1;
        }
    }

    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }

}
