package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) throws Exception {
        this.name = name;
        validateName(name);
    }

    public void moveForwardPosition(int randomNumber){
        if (determineMove(randomNumber)){
            this.position += 1;
        }
    }

    private boolean determineMove(int randomNumber){
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public void validateName(String name) throws Exception {
        if(name.length() > 5) {
            throw new Exception("이름이 5자 초과입니다.");
        }
    }

    // 추가 기능 구현
}
