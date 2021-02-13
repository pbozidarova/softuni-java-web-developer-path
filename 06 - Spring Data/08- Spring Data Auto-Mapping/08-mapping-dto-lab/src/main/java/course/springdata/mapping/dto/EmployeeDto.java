package course.springdata.mapping.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Double salary;
    private LocalDate birthday;
    private String addressCity;

}
