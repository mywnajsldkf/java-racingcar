package racingcar;

public class Game {
    GameResult gameResult = new GameResult();

    public void playOneGame(Cars playCars){
        for (Car car: playCars.cars) {
            int randomNUmber = NumberGenerator.randomNumberGenerator();
            moveCar(car, randomNUmber);
        }
    }

    private void moveCar(Car car, int number) {
        String carName = car.getName();
        int carPosition = car.movePosition(number);
        recordResult(carName, carPosition);
    }

    private void recordResult(String carName, int carPosition) {
        gameResult.gameResultTable.put(carName, carPosition);
    }
}
