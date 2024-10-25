package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.accelerator.Accelerator;

public class CarGroup {

    private final List<Car> cars;

    CarGroup(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void accelerateAll(Accelerator accelerator) {
        for (Car car : cars) {
            car.accelerate(accelerator);
        }
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}