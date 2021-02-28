package hateoas.model;

public class OrdersDto {
    private Long id;
    private Long studentsId;
    private Long courseId;

    public OrdersDto() {
    }

    public Long getId() {
        return id;
    }

    public OrdersDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getStudentsId() {
        return studentsId;
    }

    public OrdersDto setStudentsId(Long studentsId) {
        this.studentsId = studentsId;
        return this;
    }

    public Long getCourseId() {
        return courseId;
    }

    public OrdersDto setCourseId(Long courseId) {
        this.courseId = courseId;
        return this;
    }

    public static OrdersDto asDto(Order order){
        return new OrdersDto()
                        .setCourseId(order.getCourse().getId())
                        .setStudentsId(order.getStudent().getId());
    }
}
