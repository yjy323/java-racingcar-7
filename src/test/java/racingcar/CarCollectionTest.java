package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarCollectionTest {

    @Test
    public void 자동차이름목록_쉼표기준분리_5글자이하_테스트() throws Exception {
        //Given
        String carNames = "pobi,woni,jun";

        //When, Then
        Assertions.assertThatCode(() -> new CarCollection(CarRacing.parseCarList(carNames)))
                .doesNotThrowAnyException();
    }

    @Test
    public void 자동차이름목록_쉼표_외_문자기준분리_5글자이하_예외테스트() throws Exception {
        //Given
        String carNames = "pobi,woni:jun";

        //When
        Assertions.assertThatCode(() -> new CarCollection(CarRacing.parseCarList(carNames)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차이름_중복허용_테스트() throws Exception {
        //Given
        String carNames = "pobi,pobi,pobi";

        //When, Then
        Assertions.assertThatCode(() -> new CarCollection(CarRacing.parseCarList(carNames)))
                .doesNotThrowAnyException();
    }
}