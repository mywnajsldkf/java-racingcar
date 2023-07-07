package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    List<Car> cars = new ArrayList<>();
    private static final String TOKENIZER = ",";

    Cars(String carNames) throws Exception {
        splitCarNames(carNames);
    }

    private void splitCarNames(String names) throws Exception {
        String[] carNames = SplitString.splitString(names, TOKENIZER);

        for(String name : carNames){
            cars.add(new Car(name));
        }
    }
}
