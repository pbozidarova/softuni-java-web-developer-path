package course.springdata.codefirst.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle{
    @Column(name = "load_capacity")
    private double loadCapacity;

    public Truck(String model, BigDecimal price, String fuelType, double seats) {
        super(model, price, fuelType);
        this.loadCapacity = seats;
    }

    public Truck() {
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public Truck setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
        return this;
    }

    public Truck setSeats(int seats) {
        this.loadCapacity = seats;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append(super.toString());
        sb.append("load capacity=").append(loadCapacity);
        sb.append('}');
        return sb.toString();
    }
}
