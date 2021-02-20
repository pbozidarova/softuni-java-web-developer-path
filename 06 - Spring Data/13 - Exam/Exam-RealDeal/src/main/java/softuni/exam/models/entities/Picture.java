package softuni.exam.models.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {
    private LocalDateTime dateAndTime;
    private String name;
    private Car car;
    private Set<Offer> offers;

    public Picture() {
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "offers_pictures",
                joinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "picture_id", referencedColumnName = "id"))
    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
