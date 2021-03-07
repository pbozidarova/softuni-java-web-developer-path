package bg.softuni.liquibase.model;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "myentity")
@Entity
public class MyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", nullable = false, updatable = false)
  private long id;

  @Column(name = "ends_on")
  private Instant endsOn;

  public long getId() {
    return id;
  }

  public MyEntity setId(long id) {
    this.id = id;
    return this;
  }

  public Instant getEndsOn() {
    return endsOn;
  }

  public MyEntity setEndsOn(Instant endsOn) {
    this.endsOn = endsOn;
    return this;
  }
}
