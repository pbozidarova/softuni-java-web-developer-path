package com.spirngdata.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
public class Order extends BaseEntity {

    private User user;
    private List<Game> orderedGames;

    public Order() {
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    @ManyToMany
    public List<Game> getOrderedGames() {
        return orderedGames;
    }

    public Order setOrderedGames(List<Game> orderedGames) {
        this.orderedGames = orderedGames;
        return this;
    }
}
