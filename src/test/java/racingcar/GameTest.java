package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;
    @BeforeEach
    public void init(){
        game = new Game();
    }

    @Test
    @DisplayName("자동차가 한 게임을 진행하고 결과 이동거리가 예측과 같으면 성공")
    void success_IfExpectedResultIsEqualToActualMoveDistance() throws Exception {
        //given
        String testPlayCarNames = "Kenny,July,Tami,Ray,Danny";
        Cars testCars = new Cars(testPlayCarNames);

        //when
        game.playOneGame(testCars);

        //then
        for (Car car : testCars.cars) {
            assertEquals(car.getPosition(), game.gameResult.gameResultTable.get(car.getName()));
        }
    }

    @Test
    @DisplayName("해당하는 자동차 이름과 Position이 일치하면 성공")
    void success_IfCarNameAndPositionAreEqualToSavedTable() throws Exception{
        // given
        String testName = "Kenny";
        int testPosition = 1;
        Method recordResult = game.getClass().getDeclaredMethod("recordResult", String.class, int.class);
        recordResult.setAccessible(true);
        Map<String, Integer> gameResultTable = game.gameResult.gameResultTable;

        // when
        recordResult.invoke(game, testName, testPosition);

        // then
        assertEquals(gameResultTable.get(testName),1);
    }

    @Test
    @DisplayName("해당하는 자동차가 움직이면 성공")
    void success_IfNumberOver3MoveCar() throws Exception{
        // given
        String testName= "july";
        Car testCar = new Car(testName);
        Method moveCar = game.getClass().getDeclaredMethod("moveCar", Car.class, int.class);
        moveCar.setAccessible(true);

        // when
        moveCar.invoke(game, testCar, 5);

        // then
        assertEquals(game.gameResult.gameResultTable.get(testName), 1);
    }
}
