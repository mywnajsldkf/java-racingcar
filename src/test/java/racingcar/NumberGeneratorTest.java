package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    @DisplayName("생성된 랜덤 번호가 0에서 9사이가 아니면 실패")
    void randomNumberIsOutOfRange_Fail() {
        int generatedNumber;
        for(int i =0;i<10;i++){
            generatedNumber = NumberGenerator.randomNumberGenerator();
            if (generatedNumber > 9 || generatedNumber < 0) {
                Assertions.fail("실패");
            }
        }
    }
}