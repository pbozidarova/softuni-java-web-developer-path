package xml_exercise.reporistories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xml_exercise.models.entities.Sale;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT s FROM Sale as s ORDER BY s.customer.sales.size DESC")
    List<Sale> findAllBySalesMadeAndOrOrderByMoneySpentAndCarsBought();

    List<Sale> findAll();

}
