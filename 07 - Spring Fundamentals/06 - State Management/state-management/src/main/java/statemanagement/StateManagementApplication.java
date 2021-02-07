package statemanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class StateManagementApplication {

    @Autowired
    private MyConfiguration myConfiguration;

    @Autowired
    private MyBean myBean;
    public static void main(String[] args) {
        SpringApplication.run(StateManagementApplication.class, args);
    }

    @PostConstruct
    public void afterInit(){
        myBean.hello();
        myConfiguration.createNewBean().hello();
    }
}

@Configuration
class MyConfiguration{
    @Bean
    public MyBean createBean(){
        return new MyBean();
    }

    public MyBean createNewBean(){
        return createBean();
    }
}

class MyBean{
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBean.class);

    public MyBean(){
        LOGGER.info("MyBean " + hashCode() + " is created");
    }

    public void hello(){
        LOGGER.info("Hello from my bean {}!", hashCode());
    }
}