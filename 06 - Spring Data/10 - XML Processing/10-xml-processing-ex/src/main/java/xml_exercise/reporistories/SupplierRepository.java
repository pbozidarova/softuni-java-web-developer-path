package xml_exercise.reporistories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xml_exercise.models.entities.Supplier;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
        Supplier findByName(String name);

        //@Query("SELECT s FROM Supplier as s WHERE s.")
        List<Supplier> findAllByImporter(Boolean isImporter);

}
