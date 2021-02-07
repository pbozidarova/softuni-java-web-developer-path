package course.springdata.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="accounts")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private int id;
    private BigDecimal balance;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @ToString.Exclude
    private User user;
    
}
