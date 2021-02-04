package course.springdata.codefirst.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class Car extends Vehicle{
    private int seats;

    public Car(String model, BigDecimal price, String fuelType, int seats) {
        super(model, price, fuelType);
        this.seats = seats;
    }

    public Car() {
    }

    public int getSeats() {
        return seats;
    }

    public Car setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append(super.toString());
        sb.append("seats=").append(seats);
        sb.append('}');
        return sb.toString();
    }
}
