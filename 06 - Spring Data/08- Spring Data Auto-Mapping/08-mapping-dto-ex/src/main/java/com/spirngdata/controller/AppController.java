package com.spirngdata.controller;

import com.spirngdata.model.dto.UserRegisterDto;
import com.spirngdata.service.UserService;
import com.spirngdata.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import java.io.BufferedReader;

@Component
public class AppController   implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final ValidationUtil validationUtil;

    @Autowired
    public AppController(BufferedReader bufferedReader, ModelMapper modelMapper, UserService userService, ValidationUtil validationUtil) {
        this.bufferedReader = bufferedReader;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.validationUtil = validationUtil;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please provide input: ");
        while (true){
            String[] input =
                    this.bufferedReader.readLine().split("\\|");

            switch (input[0]){
                case "RegisterUser":
                    registerUser(input);
                    break;
                default:
                    break;

            }
        }

    }

    private void registerUser(String[] input) {
        if(!input[2].equals(input[3])){
            System.out.println("Passwords do not match!");
            return;
        }
        UserRegisterDto userRegisterDto = new UserRegisterDto(input[1], input[2], input[4]);
        if(this.validationUtil.isValid(userRegisterDto)){
            this.userService.registerUser(userRegisterDto);
            System.out.printf("%s was registered%n", userRegisterDto.getFullName());
        }else {
            this.validationUtil
                    .getViolations(userRegisterDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }
    }
}
