package course.springdata.advanced.init;

import course.springdata.advanced.dao.IngredientRepository;
import course.springdata.advanced.dao.LabelRepository;
import course.springdata.advanced.dao.ShampooRepository;
import course.springdata.advanced.entity.Ingredient;
import course.springdata.advanced.entity.Shampoo;
import course.springdata.advanced.util.PrintUtil;
import org.hibernate.sql.Delete;
import org.hibernate.sql.Select;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static course.springdata.advanced.entity.SizeEnum.MEDIUM;

@Component
public class AppInitializer implements CommandLineRunner {

    private final ShampooRepository shampooRepository;
    private final LabelRepository labelRepository;
    private final IngredientRepository ingredientRepository;
    private Scanner scanner = new Scanner(System.in);

    @Autowired
    public AppInitializer(ShampooRepository shampooRepository, @Lazy LabelRepository labelRepository, IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.labelRepository = labelRepository;
        this.ingredientRepository = ingredientRepository;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please choose a task number from 1 to 10 in order to review it: ");
        String task = scanner.nextLine();

        switch (task) {
            case "1":
                //Create a method that selects all shampoos with a given size, ordered by shampoo id.
                //1.	Select Shampoos by Size
                fetchShampoosBySize();
                break;
            case "2":
                //2.	Select Shampoos by Size or Label
                //Create a method that selects all shampoos with a given size or label id. Sort the result ascending by price.
                //Fetch Shampoos by Size
                fetchShampoosBySizeOrLabel();
                break;
            case "3":
                //3.	Select Shampoos by Price
                //Create a method that selects all shampoos, which price is higher than a given price. Sort the result descending by price.
                //Fetch Shampoos by Price greater then or equal
                fetchShampoosByPrice();
                break;
            case "4":
                //Fetch Shampoos by Price between min and max
                fetchShampoosByPriceBetween();
                break;
            case "5":
                //5.	Select Ingredients by Names
                //Create a method that selects all ingredients, which are contained in a given list. Sort the result ascending by price.
                fetchIngredientByName();
                break;
            case "6":
//                6.	Count Shampoos by Price
                 //Create a method that counts all shampoos with price lower than a given price.
                countShampoosByPrice();
                break;
            case "7":
                //7.	Select Shampoos by Ingredients
                //Fetch Shampoos by Ingredients in List
                fetchShampoosByIngredients();
                break;
            case "8":
                //8.	Select Shampoos by Ingredients Count
                //Create a method that selects all shampoos with ingredients less than a given number.
                //Fetch Shampoos with ingredients count lower than
                fetchShampoosWithIngredientsCountLowerThan();
                break;
            case "9":
                //9.	Delete Ingredients by Name
                //Create a method that deletes ingredients by a given name. Use named query.
                delIngredientsByName();
                break;
            case "10":
                //10.	Update Ingredients by Price
                //Increase price of ingredients by percentage
                updateIngredientsByPrice();
                break;
            default:
                break;
        }
    }

    private void updateIngredientsByPrice() {
        ingredientRepository.findAll().forEach(PrintUtil::printIngredient);
        System.out.printf("Number of updated ingredients: %d%n%n" +
                        "After update:%n",
                ingredientRepository
                        .updatePriceOfIngredientsInList(Set.of("Lavender", "Herbs", "Apple"), 0.1)
        );
        ingredientRepository.findAll().forEach(PrintUtil::printIngredient);
    }

    private void delIngredientsByName() {

        String nameToDelete = "Macadamia Oil";
        Ingredient ingredientToDelete = ingredientRepository.findByName(nameToDelete).get();
        List<Shampoo> shampoosByIngredient = shampooRepository.findByIngredient(ingredientToDelete);
        shampoosByIngredient.forEach(PrintUtil::printShampoo);

        shampoosByIngredient.forEach(s -> s.getIngredients().remove(ingredientToDelete));

        System.out.printf("Number of deleted ingredients with name=%s is %d",
                nameToDelete,
                ingredientRepository.deleteAllByName(nameToDelete));

        System.out.println("-".repeat(150));

        shampooRepository.findAll().forEach(PrintUtil::printShampoo);


    }

    private void fetchShampoosWithIngredientsCountLowerThan() {
           shampooRepository
                .findByCountOfIngredientLowerThan(5)
                .forEach(PrintUtil::printShampoo);


    }

    private void fetchShampoosByIngredients() {
        shampooRepository
                .findWithIngredientsIn(Set.of("Berry", "Mineral-Collagen"))
                .forEach(PrintUtil::printShampoo);


    }

    private void countShampoosByPrice() {
        double maxPrice = 8.5;
        System.out.printf("Number of shampoo with price less than %5.2f is: %d%n",
                maxPrice,
                shampooRepository.countShampooByPriceLessThan(8.50));
    }

    private void fetchIngredientByName() {
           ingredientRepository
                .findByNameIn(Set.of("Lavender", "Herbs", "Apple"))
                .forEach(PrintUtil::printIngredient);
    }

    private void fetchShampoosByPriceBetween() {
        shampooRepository
                .findByPriceBetween(5, 8)
                .forEach(PrintUtil::printShampoo);
    }

    private void fetchShampoosByPrice() {
        shampooRepository
                .findByPriceGreaterThanEqual(5)
                .forEach(PrintUtil::printShampoo);
    }

    private void fetchShampoosBySizeOrLabel() {
        shampooRepository
                .findBySizeAndLabelOrderByPriceDesc(MEDIUM, labelRepository.findByTitle("Vital").get())
                .forEach(PrintUtil::printShampoo);
    }

    private void fetchShampoosBySize() {
        shampooRepository
                .findBySizeOrderById(MEDIUM)
                .forEach(PrintUtil::printShampoo);
    }
}
