package bg.softuni.cloudinary.model;

import org.springframework.web.multipart.MultipartFile;

public class StudentBindingModel {

  private String id;
  private String name;
  private MultipartFile img;

  public String getId() {
    return id;
  }

  public StudentBindingModel setId(String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public StudentBindingModel setName(String name) {
    this.name = name;
    return this;
  }

  public MultipartFile getImg() {
    return img;
  }

  public StudentBindingModel setImg(MultipartFile img) {
    this.img = img;
    return this;
  }
}
