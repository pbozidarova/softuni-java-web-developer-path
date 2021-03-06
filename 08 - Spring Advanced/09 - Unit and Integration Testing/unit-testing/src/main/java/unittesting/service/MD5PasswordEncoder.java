package unittesting.service;

import org.springframework.stereotype.Service;

@Service
public class MD5PasswordEncoder implements PasswordEncoder{

    @Override
    public String encode(String text) {
        return null;
    }
}
