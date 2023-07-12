package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) throws Exception {
        this.name = name;
        validateName(name);
    }

    public int movePosition(int randomNumber){
        if (determineMove(randomNumber)){
            this.position += 1;
        }
        return this.position;
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

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
