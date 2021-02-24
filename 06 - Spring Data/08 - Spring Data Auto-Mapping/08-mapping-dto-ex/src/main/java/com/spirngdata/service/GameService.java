package com.spirngdata.service;

import com.spirngdata.model.dto.GameAddDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface GameService {
    void addGame(GameAddDto gameAddDto);
    void setGameEditDtoFields(long gameId, List<String> fields) throws InvocationTargetException, IllegalAccessException;
}
