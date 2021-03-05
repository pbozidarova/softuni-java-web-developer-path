package playground.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.SmartValidator;

import java.util.List;

@Component
public class ValidationTest implements CommandLineRunner {

    @Autowired
    SmartValidator validator;

    @Override
    public void run(String... args) throws Exception {
        CityDTO validCity = new CityDTO().setName("sofia").setPostalCodes(List.of("1111", "3234"));
        Errors errors = new BeanPropertyBindingResult(validCity, "valid city");

        validator.validate(validCity, errors);

        if(errors.hasErrors()){
            System.out.println("Should not happen!");
        }

        CityDTO invalidCity = new CityDTO().setName("plovdiv").setPostalCodes(List.of("11", "12", "123", "3234", "11111"));
        errors = new BeanPropertyBindingResult(validCity, "invalid city");

        validator.validate(validCity, errors);

        if(errors.hasErrors()){
            errors.getAllErrors().forEach(System.out::println);
        }


    }
}
