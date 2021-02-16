package com.spirngdata.service.impl;


import com.spirngdata.model.dto.GameAddDto;
import com.spirngdata.model.entity.Game;
import com.spirngdata.repository.GameRepository;
import com.spirngdata.service.GameService;
import com.spirngdata.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, UserService userService) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
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

}
