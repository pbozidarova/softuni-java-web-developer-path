package xml_exercise.services;

import xml_exercise.models.dto.*;
import xml_exercise.models.entities.Car;

import java.util.List;

public interface CarService {
    void seedCars(List<CarSeedDto> carSeedDtos);

    Car getRandomCar();

    CarViewRootDto getToyotaCars();

    CarPartsViewRootDto getAllCarsWithTheirParts();
}
