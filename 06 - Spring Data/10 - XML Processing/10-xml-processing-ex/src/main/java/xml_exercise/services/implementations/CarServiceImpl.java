package xml_exercise.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml_exercise.models.dto.*;
import xml_exercise.models.entities.Car;
import xml_exercise.reporistories.CarRepository;
import xml_exercise.services.CarService;
import xml_exercise.services.PartService;
import xml_exercise.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PartService partService;
    private final Random random;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, ValidationUtil validationUtil, PartService partService, Random random) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.partService = partService;
        this.random = random;
    }

    @Override
    public void seedCars(List<CarSeedDto> carSeedDtos) {
        carSeedDtos
                .forEach(carSeedDto -> {
                    if(this.validationUtil.isValid(carSeedDto)){
                        if(this.carRepository.findByMakeAndModelAndTravelledDistance(
                                carSeedDto.getMake(), carSeedDto.getModel(), carSeedDto.getTravelledDistance())==null){
                            Car car = this.modelMapper.map(carSeedDto, Car.class);
                            car.setParts(this.partService.getRandomParts());
                            this.carRepository.saveAndFlush(car);
                        }else {
                            System.out.println("This car is already in the database.");
                        }
                    }else{
                        this.validationUtil.violations(carSeedDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                } );
    }

    @Override
    public Car getRandomCar() {
        long randomId = this.random.nextInt((int) this.carRepository.count()) + 1;
        return this.carRepository.getOne(randomId);
    }

    @Override
    public CarViewRootDto getToyotaCars() {
        CarViewRootDto carViewRootDto = new CarViewRootDto();

        List<CarViewDto> carViewDtos = this.carRepository.carsToyotaOrderedByModelAndTravelledDistance("Toyota")
                .stream()
                .map(car -> this.modelMapper.map(car, CarViewDto.class))
                .collect(Collectors.toList());

        carViewRootDto.setCars(carViewDtos);

        return carViewRootDto;
    }

    @Override
    public CarPartsViewRootDto getAllCarsWithTheirParts() {
        CarPartsViewRootDto carPartsViewRootDto = new CarPartsViewRootDto();

        List<CarCarsPartsViewDto> carCarsPartsViewDto = this.carRepository.findAll()
                .stream()
                .map(car -> this.modelMapper.map(car, CarCarsPartsViewDto.class))
                .collect(Collectors.toList());

        carPartsViewRootDto.setCars(carCarsPartsViewDto);

        return carPartsViewRootDto;
    }
}
