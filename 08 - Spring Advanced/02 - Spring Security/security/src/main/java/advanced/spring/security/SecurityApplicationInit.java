package advanced.spring.security;

import advanced.spring.security.model.AuthorityEntity;
import advanced.spring.security.model.UserEntity;
import advanced.spring.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityApplicationInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityApplicationInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity user = new UserEntity();
        user.setName("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setEnabled(true);

        AuthorityEntity authorityEntity = new AuthorityEntity();
        authorityEntity.setName("ROLE_USER");
        authorityEntity.setUser(user);
        user.setAuthorities(List.of(authorityEntity));

        userRepository.save(user);


        UserEntity admin = new UserEntity();
        admin.setName("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setEnabled(true);

        AuthorityEntity adminUserAuthorityEntity = new AuthorityEntity();
        adminUserAuthorityEntity.setName("ROLE_USER");
        adminUserAuthorityEntity.setUser(admin);

        AuthorityEntity adminAuthorityEntity = new AuthorityEntity();
        adminAuthorityEntity.setName("ROLE_ADMIN");
        adminAuthorityEntity.setUser(admin);
        admin.setAuthorities(List.of(adminUserAuthorityEntity, adminAuthorityEntity));

        userRepository.save(admin);
    }
}
