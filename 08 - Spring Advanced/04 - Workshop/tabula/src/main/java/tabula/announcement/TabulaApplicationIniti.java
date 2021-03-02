package tabula.announcement;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tabula.announcement.model.AnnouncementEntity;
import tabula.announcement.repository.AnnouncementRepository;

import java.time.Instant;

@AllArgsConstructor
@Component
public class TabulaApplicationIniti implements CommandLineRunner {
    private final AnnouncementRepository announcementRepository;

    @Override
    public void run(String... args) throws Exception {
        if(announcementRepository.count() == 0){
            AnnouncementEntity announcementEntity = new AnnouncementEntity();
            announcementEntity.setTitle("Hello, SoftUni!");
            announcementEntity.setDescription("Welcome to the Spring advanced course!");
            announcementEntity.setCreatedOn(Instant.now());
            announcementEntity.setUpdatedOn(Instant.now());

            announcementRepository.save(announcementEntity);
        }
    }
}
