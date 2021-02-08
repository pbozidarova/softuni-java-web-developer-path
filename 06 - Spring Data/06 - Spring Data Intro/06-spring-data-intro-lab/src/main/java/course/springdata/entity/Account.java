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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Account extends BaseEntity {

    @NonNull
    private BigDecimal balance;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @ToString.Exclude
    private User user;

}
