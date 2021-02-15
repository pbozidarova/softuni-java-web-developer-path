package com.spirngdata.model.entity;

import javax.persistence.*;
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
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

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
