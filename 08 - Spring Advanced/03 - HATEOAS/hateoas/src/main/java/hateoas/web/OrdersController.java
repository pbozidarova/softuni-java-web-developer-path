package hateoas.web;

import hateoas.model.Course;
import hateoas.model.Order;
import hateoas.model.OrdersDto;
import hateoas.model.Student;
import hateoas.repository.CourseRepository;
import hateoas.repository.OrderRepository;
import hateoas.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final StudentRepository studentRepository;
    private final OrderRepository orderRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public OrdersController(StudentRepository studentRepository, OrderRepository orderRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.orderRepository = orderRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public ResponseEntity<EntityModel<OrdersDto>> createOrder(
            @RequestBody OrdersDto ordersDto){
        //TODO validation
        Student student = studentRepository.getOne(ordersDto.getId());
        Course course = courseRepository.getOne(ordersDto.getCourseId());

        Order newOrder = new Order();
        newOrder.setStudent(student);
        newOrder.setCourse(course);

        newOrder = this.orderRepository.save(newOrder);

        //todo build order links

        return ResponseEntity.ok(EntityModel.of(OrdersDto.asDto(newOrder)));
    }

}
