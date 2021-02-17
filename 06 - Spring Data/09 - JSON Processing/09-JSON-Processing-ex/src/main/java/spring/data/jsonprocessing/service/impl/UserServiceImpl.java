package spring.data.jsonprocessing.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import spring.data.jsonprocessing.model.dto.UserSeedDto;
import spring.data.jsonprocessing.model.entity.User;
import spring.data.jsonprocessing.repository.UserRepository;
import spring.data.jsonprocessing.service.UserService;
import spring.data.jsonprocessing.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.Arrays;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers(UserSeedDto[] userSeedDtos) {
        if(this.userRepository.count() !=  0){
            return;
        }

        Arrays.stream(userSeedDtos)
                .forEach(userSeedDto -> {
                    if(this.validationUtil.isValid(userSeedDto)){
                        User user = this.modelMapper.map(userSeedDto, User.class);

                        this.userRepository.saveAndFlush(user);
                    }else {
                        this.validationUtil.violations(userSeedDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                });
    }

    @Override
    public User getRandomUser() {
        Random random = new Random();
        long randomId = random.nextInt((int) this.userRepository.count()) +1 ;

        return this.userRepository.getOne(randomId);
    }
}
