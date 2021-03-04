package aop.model;

import org.springframework.stereotype.Component;


@Component
public class Student {

    public void sayHello(){
        System.out.println("Hello, I am student");
    }

    public void echo(String echo){
        System.out.println("I have to echo: " + echo);
    }
}
