package jsonprocessing.entity;

import com.google.gson.annotations.Expose;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post {
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Expose
    @NonNull
    @NotNull
    @Length(min=3, max=80, message = "Title must be with length between 3 and 80 characters!")
    private String title;

    @Expose
    @NonNull
    @NotNull
    @Length(min=3, max=2048, message = "Title must be with length between 3 and 2048 characters!")
    private String content;

    @Expose
    @NonNull
    @NotNull
    @URL(message = "Please provide a valid URL!")
    private String imageUrl;

    @Expose
    @ManyToOne
    private User author;

    @Expose(serialize = false)
    @NonNull
    @NotNull
    @Transient
    private Long authorId;

    @Expose
    private LocalDateTime created = LocalDateTime.now();
    @Expose
    private LocalDateTime modified = LocalDateTime.now();

}
