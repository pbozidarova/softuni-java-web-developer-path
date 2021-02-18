package xml_exercise.reporistories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xml_exercise.models.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByMakeAndModelAndTravelledDistance(String make, String model, Integer travelledDistance);

    @Query("SELECT c FROM Car as c WHERE c.make = :toyota ORDER BY c.model, c.travelledDistance DESC")
    List<Car> carsToyotaOrderedByModelAndTravelledDistance(@Param("toyota") String toyota);

    List<Car> findAll();
}
