package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) throws Exception {
        this.name = name;
        validateName(name);
    }

    public void validateName(String name) throws Exception {
        if(name.length() > 5) {
            throw new Exception("이름이 5자 초과입니다.");
        }
    }

    // 추가 기능 구현
}
