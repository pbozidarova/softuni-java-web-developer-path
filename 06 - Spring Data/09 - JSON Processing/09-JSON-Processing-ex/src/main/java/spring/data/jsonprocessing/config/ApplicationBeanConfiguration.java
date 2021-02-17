package spring.data.jsonprocessing.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.data.jsonprocessing.util.FileIOUtil;
import spring.data.jsonprocessing.util.ValidationUtil;
import spring.data.jsonprocessing.util.impl.FileIOUtilImpl;
import spring.data.jsonprocessing.util.impl.ValidationUtilImpl;

import java.beans.BeanProperty;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson(){
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    };

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ValidationUtil validationUtil(){
        return new ValidationUtilImpl();
    }

    @Bean
    FileIOUtil fileIOUtil(){
        return new FileIOUtilImpl();
    }
}
