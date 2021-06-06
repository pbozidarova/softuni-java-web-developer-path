package com.softuni.ebank.services;

import com.softuni.ebank.bindingModels.UserBindingModel;
import com.softuni.ebank.entities.Role;
import com.softuni.ebank.entities.User;
import com.softuni.ebank.repositories.RoleRepository;
import com.softuni.ebank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = this.userRepository.findByUsername(username);

        if (userDetails == null) {
            throw new UsernameNotFoundException("Invalid user!");
        }

        return userDetails;
    }

    public boolean register(UserBindingModel model){
        User user = this.userRepository.findByUsername(model.getUsername());

        if(user != null){
            return false;
        }else if(!model.getPassword().equals(model.getConfirmPassword())){
            return false;
        }

        Role role =
                this.roleRepository.findByAuthority(
                        this.userRepository.count() == 0 ?
                                "ADMIN" : "USER"
                );

        if(role == null) {
            return false;
        }

        user = new User();
        user.setEmail(model.getEmail());
        user.setUsername(model.getUsername());
        user.setPassword(encoder.encode(model.getPassword()));
        user.addRole(role);

        return this.userRepository.saveAndFlush(user) != null;
    }
}

