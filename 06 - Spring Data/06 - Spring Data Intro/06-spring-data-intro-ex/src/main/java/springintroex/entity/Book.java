package springintroex.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="books")
public class Book extends BaseEntity {

    private String title;
    private String description;
    private EditionType editionType;
    private BigDecimal price;
    private int copies;
    private LocalDate releaseDate;
    private AgeRestriction ageRestriction;

    private Set<Category> categories;
    private Author author;

    public Book() {
    }

    @Column(name="title", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    @Column(name="description", length = 1000)
    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }
    @Column(name="edition_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    public EditionType getEditionType() {
        return editionType;
    }

    public Book setEditionType(EditionType editionType) {
        this.editionType = editionType;
        return this;
    }
    @Column(name="price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public Book setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    @Column(name="copies", nullable = false)
    public int getCopies() {
        return copies;
    }

    public Book setCopies(int copies) {
        this.copies = copies;
        return this;
    }
    @Column(name="release_date")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Book setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @Column(name="age_restriction", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public Book setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
        return this;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Category> getCategories() {
        return categories;
    }

    public Book setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name="author_id", referencedColumnName = "id")
    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }
}
