package bg.softuni.mobilele.mobilele.repository;

import bg.softuni.mobilele.mobilele.model.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
