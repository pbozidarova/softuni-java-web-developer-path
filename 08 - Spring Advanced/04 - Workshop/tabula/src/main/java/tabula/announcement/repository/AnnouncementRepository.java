package tabula.announcement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tabula.announcement.model.AnnouncementEntity;

import java.time.Instant;

@Repository
public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, Long> {

    void deleteByUpdatedOnBefore(Instant before);
}
