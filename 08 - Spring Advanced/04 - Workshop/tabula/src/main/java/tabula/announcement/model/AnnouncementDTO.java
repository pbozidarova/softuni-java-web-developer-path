package tabula.announcement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import java.time.Instant;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnnouncementDTO {

    private Long id;

    private Instant createdOn;

    private Instant updatedOn;

    @NotNull
    private String title;

    @NotNull
    @Size(min=10, message = "The description should be more than 10 characters.")
    private String description;

}
