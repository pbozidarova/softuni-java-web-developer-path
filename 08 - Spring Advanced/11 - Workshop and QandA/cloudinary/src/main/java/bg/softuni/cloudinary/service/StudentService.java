package bg.softuni.cloudinary.service;

import bg.softuni.cloudinary.model.Student;
import bg.softuni.cloudinary.model.StudentBindingModel;
import bg.softuni.cloudinary.repository.StudentRepository;
import java.io.IOException;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final ModelMapper modelMapper;
  private final StudentRepository studentRepository;
  private final CloudinaryService cloudinaryService;

  public StudentService(ModelMapper modelMapper,
      StudentRepository studentRepository,
      CloudinaryService cloudinaryService) {

    this.modelMapper = modelMapper;
    this.studentRepository = studentRepository;
    this.cloudinaryService = cloudinaryService;
  }

  public void addStudent(StudentBindingModel studentBindingModel) throws IOException {
    Student student = this.modelMapper.map(studentBindingModel,
        Student.class);

    String url = this.cloudinaryService.uploadImage(studentBindingModel.getImg());
    student.setImg(url);

    studentRepository.save(student);
  }

  public List<Student> findAll() {
    return  studentRepository.findAll();
  }
}
