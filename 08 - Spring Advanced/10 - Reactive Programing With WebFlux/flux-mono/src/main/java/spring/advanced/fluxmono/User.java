package spring.advanced.fluxmono;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class User {
    private String firstName, lastName;

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}