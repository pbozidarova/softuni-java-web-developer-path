package com.prep.model.entity;

import javax.persistence.*;

@Entity
@Table
public class Category extends BaseEntity {
    private CategoryName name;
    private String description;

    public Category() {
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public CategoryName getName() {
        return name;
    }

    public Category setName(CategoryName name) {
        this.name = name;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
