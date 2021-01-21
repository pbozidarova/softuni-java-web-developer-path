package bg.softuni.mobilele.mobilele.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="brands")
public class BrandEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }


    @Override
    public String toString() {
        return "BrandEntity{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", name='" + name + '\'' +
                '}';
    }
}
