package com.spirngdata.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class User extends BaseEntity {
    private String email;
    private String password;
    private String fullName;
    private Set<Game> games;
    private Role role;
    private Set<Order> orders;

    public User() {
    }

    @Column(name="email", unique = true)
    @Pattern(regexp = ".+@.+\\..+", message = "Email is not valid!")
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Pattern(regexp = "[A-Z]+[a-z]+[0-9]+", message = "Password not valid")
    @Size(min = 6, message = "Pass length not valid!")
    @NotNull
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotNull(message = "Full name must not be null!")
    @Column(name="full_name")
    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @ManyToMany
    @JoinTable(name = "users_games",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "games_id", referencedColumnName = "id")})
    public Set<Game> getGames() {
        return games;
    }

    public User setGames(Set<Game> games) {
        this.games = games;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    @OneToMany(mappedBy = "user")
    public Set<Order> getOrders() {
        return orders;
    }

    public User setOrders(Set<Order> orders) {
        this.orders = orders;
        return this;
    }
}
