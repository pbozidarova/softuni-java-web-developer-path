package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.models.dtos.CarSeedDto;
import softuni.exam.models.entities.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.carRepository = carRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder result = new StringBuilder();

        CarSeedDto[] dtos = this.gson.fromJson(new FileReader(CARS_FILE_PATH), CarSeedDto[].class);

        Arrays.stream(dtos).forEach(carSeedDto ->  {
            if (this.validationUtil.isValid(carSeedDto)) {
                if(this.carRepository.findByMakeAndModelAndKilometers
                        (carSeedDto.getMake(), carSeedDto.getModel(), carSeedDto.getKilometers()) == null){
                    Car car = this.modelMapper.map(carSeedDto, Car.class);
                    LocalDate localDateRegOn = LocalDate.parse(carSeedDto.getRegisteredOn(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    car.setRegisteredOn(localDateRegOn);

                    this.carRepository.saveAndFlush(car);

                    result.append(SUCCESS_MESSAGE + "car - " + carSeedDto.getMake() + " - " + carSeedDto.getModel());

                }else{
                    result.append(ALREADY_IN_DB_MESSAGE);
                }
            }else{
                result.append(String.format(INVALID_DATA_MESSAGE, "car"));
            }
            result.append(System.lineSeparator());

        });

        return result.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder result = new StringBuilder();

        List<Car> cars = this.carRepository.findByPicturesCountAndOrderByCountAndMake();

        cars.forEach(car -> {
            result.append(String.format("Car make - %s, model - %s\n" +
                    "\tKilometers - %d\n" +
                    "\tRegistered on - %s\n" +
                    "\tNumber of pictures - %d\n",
                        car.getMake(), car.getModel(),
                        car.getKilometers(),
                        car.getRegisteredOn().toString(),
                        car.getPictures().size()
                    )).append(System.lineSeparator());
        });

        return result.toString();
    }

    @Override
    public Car getCarById(Long id) {
        return this.carRepository.findAllById(id);
    }
}
