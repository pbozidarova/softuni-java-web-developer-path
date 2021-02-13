package com.softuni.springintroex.service.models;

import com.softuni.springintroex.domain.entities.AgeRestriction;

import java.math.BigDecimal;

public class BookInfo {
    private String title;
    private BigDecimal price;
    int copies;

    public BookInfo(String title, BigDecimal price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public BookInfo setTitle(String title) {
        this.title = title;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BookInfo setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getCopies() {
        return copies;
    }

    public BookInfo setCopies(int copies) {
        this.copies = copies;
        return this;
    }
}
