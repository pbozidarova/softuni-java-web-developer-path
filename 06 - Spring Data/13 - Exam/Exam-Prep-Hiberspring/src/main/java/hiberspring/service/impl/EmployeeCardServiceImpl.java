package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.GlobalConstants;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.domain.models.EmployeeCardSeedDto;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static hiberspring.common.GlobalConstants.*;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {
    private final EmployeeCardRepository employeeCardRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.employeeCardRepository = employeeCardRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return Files.readString(Paths.get(EMPLOYEE_CARDS_FILE_PATH));
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        EmployeeCardSeedDto[] employeeCardSeedDtos = this.gson.fromJson(new FileReader(EMPLOYEE_CARDS_FILE_PATH), EmployeeCardSeedDto[].class);

        Arrays.stream(employeeCardSeedDtos).forEach(employeeCardSeedDto -> {
            if(this.validationUtil.isValid(employeeCardSeedDto)){
                if(this.employeeCardRepository.findAllByNumber(employeeCardSeedDto.getNumber())==null){
                    EmployeeCard employeeCard = this.modelMapper.map(employeeCardSeedDto, EmployeeCard.class);

                    sb.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, "EmployeeCard" , employeeCardSeedDto.getNumber()));

                    this.employeeCardRepository.saveAndFlush(employeeCard);
                }else{
                    sb.append("This employee card is already in the database!");
                }
            }else{
                sb.append(INCORRECT_DATA_MESSAGE);
            }
            sb.append(System.lineSeparator());

        });

        return sb.toString();
    }
}
