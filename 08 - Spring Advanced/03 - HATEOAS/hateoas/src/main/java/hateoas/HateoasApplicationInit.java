package hateoas;

import hateoas.model.Course;
import hateoas.model.Order;
import hateoas.model.Student;
import hateoas.repository.CourseRepository;
import hateoas.repository.OrderRepository;
import hateoas.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HateoasApplicationInit implements CommandLineRunner {

  private final StudentRepository studentRepository;
  private final OrderRepository orderRepository;
  private final CourseRepository courseRepository;

  public HateoasApplicationInit(
      StudentRepository studentRepository,
      OrderRepository orderRepository,
      CourseRepository courseRepository) {
    this.studentRepository = studentRepository;
    this.orderRepository = orderRepository;
    this.courseRepository = courseRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Student ivan = new Student();
    ivan.setName("Ivan");
    ivan.setAge(21);

    ivan = studentRepository.save(ivan);

    Course springDataCourse = new Course();
    springDataCourse.setName("Spring Data");
    springDataCourse.setPrice(100.0);
    springDataCourse.setEnabled(true);

    springDataCourse = courseRepository.save(springDataCourse);


    Course springBatchCourse = new Course();
    springBatchCourse.setName("Spring Batch");
    springBatchCourse.setPrice(150.0);
    springBatchCourse.setEnabled(false);

    springBatchCourse = courseRepository.save(springBatchCourse);


    Order ivanSpringData = new Order();
    ivanSpringData.setCourse(springDataCourse);
    ivanSpringData.setStudent(ivan);

    orderRepository.save(ivanSpringData);
  }
}
