package com.spirngdata.service.impl;


import com.spirngdata.model.dto.GameAddDto;
import com.spirngdata.model.dto.GameEditDto;
import com.spirngdata.model.entity.Game;
import com.spirngdata.repository.GameRepository;
import com.spirngdata.service.GameService;
import com.spirngdata.service.UserService;
import com.spirngdata.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final ValidationUtil validationUtil;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, UserService userService, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        Game game = this.modelMapper
                .map(gameAddDto, Game.class);
        if(!userService.isLoggedUserIsAdmin()){
            System.out.println("Logged user is not admin!");
            return;
        }

        System.out.printf("Added %s%n", game.getTitle());
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public void setGameEditDtoFields(long gameId, List<String> fields) throws InvocationTargetException, IllegalAccessException {
        Game game = this.gameRepository.findById(gameId);
        GameEditDto gameEditDto = this.modelMapper.map(game, GameEditDto.class);

        System.out.println();

        for (int i = 0; i < fields.size(); i++) {
            String fieldName = fields.get(i).split("=")[0];
            String fieldValue = fields.get(i).split("=")[1];

            Method fieldSetter = this.getFieldSetter(fieldName);
            if (fieldSetter == null) {
                System.out.println(fieldName + " is invalid field name.");
            }

            if (this.validationUtil.isValid(gameEditDto)) {
                fieldSetter.invoke(gameEditDto, setDataType(fieldName, fieldValue));

                this.gameRepository.save(this.modelMapper.map(gameEditDto, Game.class));
            } else {
                this.validationUtil.getViolations(gameEditDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }

        }
    }

    private Object setDataType(String fieldName, String fieldValue) {
        Object fieldValueWithCorrectType = null;

        if(fieldName.equals("price")){
            fieldValueWithCorrectType = new BigDecimal(fieldValue);
        }else if(fieldName.equals("size")){
            fieldValueWithCorrectType = Double.parseDouble(fieldValue);
        }else if(fieldName.equals("date")){
            fieldValueWithCorrectType = LocalDate.parse(fieldValue, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }

        return fieldValueWithCorrectType;
    }


    private Method getFieldSetter(String fieldName) {
        String PREFIX = "set";
        String fieldMethodName = PREFIX + fieldName;

        Method fieldSetter = Arrays.stream(GameEditDto.class.getDeclaredMethods())
                .filter(method -> method.getName().toLowerCase().equals(fieldMethodName))
                .findFirst()
                .orElse(null);

        return fieldSetter;
    }

}
