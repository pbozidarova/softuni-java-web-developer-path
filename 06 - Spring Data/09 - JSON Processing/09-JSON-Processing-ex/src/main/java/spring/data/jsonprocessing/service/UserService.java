package spring.data.jsonprocessing.service;

import spring.data.jsonprocessing.model.dto.UserSeedDto;
import spring.data.jsonprocessing.model.entity.User;

public interface UserService {
    void seedUsers(UserSeedDto[] userSeedDtos);

    User getRandomUser();
}
