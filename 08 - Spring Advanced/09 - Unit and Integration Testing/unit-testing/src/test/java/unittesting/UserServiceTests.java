package unittesting;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import unittesting.entity.User;
import unittesting.repository.UserRepository;
import unittesting.service.MD5PasswordEncoder;
import unittesting.service.PasswordEncoder;
import unittesting.service.UserService;
import unittesting.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
//@DataJpaTest
@ActiveProfiles("test")
public class UserServiceTests {

    private static final String PASSWORD_HASH = "myCustomHash";

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    private void setUp(){
        when(this.passwordEncoder.encode(anyString()))
                .thenReturn(PASSWORD_HASH);
    }

    @Test
    public void testRegister_withUsernameAndPassword_passwordShouldBeEncoded(){

        when(this.userRepository.save(any())).thenAnswer(i -> i.getArgument(0));

        final String USERNAME = "pesho";
        final String PASSWORD = "pesho123";

        //act
        User result = this.userService.register(USERNAME, PASSWORD);

        assertEquals("Password was not or wrongly encoded!",
                                PASSWORD_HASH,
                                result.getPassword());
    }

}
