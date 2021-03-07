package bg.softuni.cloudinary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String img;

  public Long getId() {
    return id;
  }

  public Student setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Student setName(String name) {
    this.name = name;
    return this;
  }

  public String getImg() {
    return img;
  }

  public Student setImg(String img) {
    this.img = img;
    return this;
  }
}
