package ice.demo.test.demo.controller.response;

import ice.demo.test.demo.model.Car;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class CarsControllerSaveCarsResponse {

    private List<Car> cars = new LinkedList<>();

    private boolean success;

    public void addCar(Car car){
        cars.add(car);
    }
}
