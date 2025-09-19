package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if(name == null) {
            throw new IllegalArgumentException();
        }
        String trimmed = name.trim();
        if(trimmed.isEmpty() || trimmed.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = trimmed;
    }

    public String getName() { return name; }

    public void move(int randomNum) {
        if (randomNum >= 4) position++;
    }

    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for(int i = 0; i < position; i++) sb.append('-');
        return sb.toString();
    }


}
