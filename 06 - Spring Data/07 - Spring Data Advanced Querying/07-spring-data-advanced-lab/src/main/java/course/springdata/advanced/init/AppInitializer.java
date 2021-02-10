package course.springdata.advanced.init;

import course.springdata.advanced.dao.IngredientRepository;
import course.springdata.advanced.dao.LabelRepository;
import course.springdata.advanced.dao.ShampooRepository;
import course.springdata.advanced.entity.Ingredient;
import course.springdata.advanced.entity.Shampoo;
import course.springdata.advanced.util.PrintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

import static course.springdata.advanced.entity.SizeEnum.MEDIUM;

@Component
public class AppInitializer implements CommandLineRunner {

    private final ShampooRepository shampooRepository;
    private final LabelRepository labelRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public AppInitializer(ShampooRepository shampooRepository, @Lazy LabelRepository labelRepository, IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.labelRepository = labelRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        //Create a method that selects all shampoos with a given size, ordered by shampoo id.
//        //Fetch Shampoos by Size
//        shampooRepository
//                .findBySizeOrderById(MEDIUM)
//                .forEach(PrintUtil::printShampoo);
//        System.out.println("-".repeat(150));
//
//        //Create a method that selects all shampoos with a given size or label id. Sort the result ascending by price.
//        //Fetch Shampoos by Size
//        shampooRepository
//                .findBySizeAndLabelOrderByPriceDesc(MEDIUM, labelRepository.findByTitle("Vital").get())
//                .forEach(PrintUtil::printShampoo);
//        System.out.println("-".repeat(150));

//        //Create a method that selects all shampoos, which price is higher than a given price. Sort the result descending by price.
//        //Fetch Shampoos by Price greater then or equal
//        shampooRepository
//                .findByPriceGreaterThanEqual(5)
//                .forEach(PrintUtil::printShampoo);
//        System.out.println("-".repeat(170));
//
//        //Create a method that selects all shampoos, which price is higher than a given price. Sort the result descending by price.
//        //Fetch Shampoos by Price between min and max
//        shampooRepository
//                .findByPriceBetween(5, 8)
//                .forEach(PrintUtil::printShampoo);
//        System.out.println("-".repeat(170));


//        //Create a method that selects all ingredients, which are contained in a given list. Sort the result ascending by price.
//        //Fetch Shampoos by Price between min and max
//        ingredientRepository
//                .findByNameIn(Set.of("Lavender", "Herbs", "Apple"))
//                .forEach(PrintUtil::printIngredient);
//        System.out.println("-".repeat(170));
//
//        //Create a method that counts all shampoos with price lower than a given price.
//        double maxPrice = 8.5;
//        System.out.printf("Number of shampoo with price less than %5.2f is: %d%n",
//                maxPrice,
//                shampooRepository.countShampooByPriceLessThan(8.50));
//
//        System.out.println("-".repeat(170));

//
//        //Fetch Shampoos by Ingredients in List
//        shampooRepository
//                .findWithIngredientsIn(Set.of("Berry", "Mineral-Collagen"))
//                .forEach(PrintUtil::printShampoo);
//        System.out.println("-".repeat(150));

        //Create a method that selects all shampoos with ingredients less than a given number.
        //Fetch Shampoos with ingredients count lower than
//        shampooRepository
//                .findByCountOfIngredientLowerThan(5)
//                .forEach(PrintUtil::printShampoo);
//        System.out.println("-".repeat(150));
//
//        //Create a method that deletes ingredients by a given name. Use named query.
//        String nameToDelete = "Macadamia Oil";
//        Ingredient ingredientToDelete = ingredientRepository.findByName(nameToDelete).get();
//        List<Shampoo> shampoosByIngredient = shampooRepository.findByIngredient(ingredientToDelete);
//        shampoosByIngredient.forEach(PrintUtil::printShampoo);
//        shampoosByIngredient.forEach(s -> s.getIngredients().remove(ingredientToDelete));
//
//        System.out.printf("Number of deleted ingredients with name=%s is %d",
//                nameToDelete,
//                ingredientRepository.deleteAllByName(nameToDelete));
//
//        System.out.println("-".repeat(150));
//
//        shampooRepository.findAll().forEach(PrintUtil::printShampoo);

        //Increase price of ingredients by percentage
        ingredientRepository.findAll().forEach(PrintUtil::printIngredient);
        System.out.printf("Number of updated ingredients: %d%n%n" +
                        "After update:%n",
                                        ingredientRepository
                                                    .updatePriceOfIngredientsInList(Set.of("Lavender", "Herbs", "Apple"), 0.1)
        );
        ingredientRepository.findAll().forEach(PrintUtil::printIngredient);


        System.out.println("-".repeat(150));

    }
}
