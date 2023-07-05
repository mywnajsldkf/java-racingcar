package racingcar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("num이 0이면 참이다.")
    void first_test(){
        int num = 0;
        Assertions.assertThat(num).isEqualTo(0);
    }

    @Test
    @DisplayName("car name이 5자 넘어가면 exception 처리")
    void carNameIsOver5_throwException() {
        String testName = "jeongin";
        Throwable exception = assertThrows(Exception.class, ()->{
            new Car(testName);
        });
        assertEquals("이름이 5자 초과입니다.", exception.getMessage());
    }

    @Test
    @DisplayName("randomNumber 4이상이 아닐때 자동차의 position이 변경되지 않으면 성공이다.")
    void whenRandomUnder4_Stay_Success() throws Exception {
        //given
        int randomNumber = 3;
        int expectedValue = 0;
        Car carTest = new Car("july");
        Field testPosition = carTest.getClass().getDeclaredField("position");
        testPosition.setAccessible(true);
        //when
        carTest.moveForwardPosition(randomNumber);
        int positionValue = (int) testPosition.get(carTest);
        //then
        assertEquals(expectedValue, positionValue);
    }

    @Test
    @DisplayName("randomNumber 4이상일 때 자동차의 position이 1 증가하면 성공이다.")
    void whenRandomOver3_GoForward_Success() throws Exception {
        //given
        int randomNumber = 5;
        int expectedValue = 1;
        Car carTest = new Car("Kenny");
        Field testPosition = carTest.getClass().getDeclaredField("position");
        testPosition.setAccessible(true);
        //when
        carTest.moveForwardPosition(randomNumber);
        int positionValue = (int) testPosition.get(carTest);
        //then
        assertEquals(expectedValue, positionValue);
    }
}