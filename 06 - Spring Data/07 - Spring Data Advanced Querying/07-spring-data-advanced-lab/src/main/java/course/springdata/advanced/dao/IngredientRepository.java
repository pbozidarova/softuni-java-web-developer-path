package course.springdata.advanced.dao;

import course.springdata.advanced.entity.Ingredient;
import course.springdata.advanced.entity.Label;
import course.springdata.advanced.entity.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameIn(Iterable<String> ingredient_names);

    @Transactional
    int deleteAllByName(String name);

    Optional<Ingredient> findByName(String name);

    @Modifying
    @Transactional
    @Query("UPDATE Ingredient i SET i.price = i.price + i.price * :percentage WHERE i.name IN(:names)")
    int updatePriceOfIngredientsInList(@Param("names") Iterable<String> ingredient_names,
                                       @Param("percentage") double percentage);

    

}
