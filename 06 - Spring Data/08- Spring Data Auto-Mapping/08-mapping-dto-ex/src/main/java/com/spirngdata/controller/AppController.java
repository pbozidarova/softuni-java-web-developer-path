package com.spirngdata.controller;

import com.spirngdata.model.dto.GameAddDto;
import com.spirngdata.model.dto.UserLoginDto;
import com.spirngdata.model.dto.UserRegisterDto;
import com.spirngdata.model.entity.Game;
import com.spirngdata.service.GameService;
import com.spirngdata.service.UserService;
import com.spirngdata.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class AppController   implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final GameService gameService;
    private final UserService userService;
    private final ValidationUtil validationUtil;

    @Autowired
    public AppController(BufferedReader bufferedReader, GameService gameService, UserService userService, ValidationUtil validationUtil) {
        this.bufferedReader = bufferedReader;
        this.gameService = gameService;
        this.userService = userService;
        this.validationUtil = validationUtil;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
            System.out.println("Enter command: ");

            String[] input =
                    this.bufferedReader.readLine().split("\\|");

            switch (input[0]){
                case "RegisterUser":
                    registerUser(input);
                    break;
                case "LoginUser":
                    loginUser(input);
                    break;
                case "Logout":
                    logoutUser();
                    break;
                case "AddGame":
                    addGame(input);
                    break;
                default:
                    break;

            }
        }

    }

    private void addGame(String[] input) {
        GameAddDto gameAddDto = new GameAddDto(
                input[1],
                new BigDecimal(input[2]),
                Double.parseDouble(input[3]),
                input[4],
                input[5],
                input[6],
                LocalDate.parse(input[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))

        );
        if(this.validationUtil.isValid(gameAddDto)){
            this.gameService.addGame(gameAddDto);
        }else {
            this.validationUtil
                    .getViolations(gameAddDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }
    }

    private void logoutUser() {
        this.userService.logout();
    }

    private void loginUser(String[] input) {
        UserLoginDto userLoginDto = new UserLoginDto(input[1], input[2]);

        this.userService.loginUser(userLoginDto);
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
