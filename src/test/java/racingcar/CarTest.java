package racingcar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        org.junit.jupiter.api.Assertions.assertEquals("이름이 5자 초과입니다.", exception.getMessage());
    }
}