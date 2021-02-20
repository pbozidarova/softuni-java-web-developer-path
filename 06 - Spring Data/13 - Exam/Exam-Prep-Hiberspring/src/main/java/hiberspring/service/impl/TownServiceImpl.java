package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.GlobalConstants;
import hiberspring.domain.entities.Town;
import hiberspring.domain.models.TownsSeedDto;
import hiberspring.repository.TownRepository;
import hiberspring.service.TownService;
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
import static hiberspring.common.GlobalConstants.TOWNS_FILE_PATH;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    @Autowired
    public TownServiceImpl(TownRepository townRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return Files.readString(Paths.get(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns(String townsFileContent) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        TownsSeedDto[] townsSeedDtos = this.gson.fromJson(new FileReader(TOWNS_FILE_PATH), TownsSeedDto[].class);
        Arrays.stream(townsSeedDtos).forEach(townsSeedDto -> {
            if(this.validationUtil.isValid(townsSeedDto)){
                if( this.townRepository.findAllByNameAndPopulation(townsSeedDto.getName(), townsSeedDto.getPopulation()) == null){
                    Town town = this.modelMapper.map(townsSeedDto, Town.class);
                    sb.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, "Town", townsSeedDto.getName()));

                    this.townRepository.saveAndFlush(town);
                }else{
                    sb.append("This town is already in the database!");
                }
            }else{
                sb.append(INCORRECT_DATA_MESSAGE);
            }
            sb.append(System.lineSeparator());

        });

        return sb.toString();
    }

    @Override
    public Town getTownByName(String name) {
        return this.townRepository.findAllByName(name);
    }
}
