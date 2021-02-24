package com.spirngdata.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="games")
public class Game extends BaseEntity {
    private String title;
    private String trailer;
    private String imageUrl;
    private double size;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    private Set<User> users;

    public Game() {
    }

    public String getTitle() {
        return title;
    }

    public Game setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTrailer() {
        return trailer;
    }

    public Game setTrailer(String trailer) {
        this.trailer = trailer;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Game setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public double getSize() {
        return size;
    }

    public Game setSize(double size) {
        this.size = size;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Game setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Game setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Game setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @ManyToMany(mappedBy = "games")
    public Set<User> getUsers() {
        return users;
    }

    public Game setUsers(Set<User> users) {
        this.users = users;
        return this;
    }
}
