package aop;

import aop.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AopLocationInit implements CommandLineRunner {

    private final Student student;

    public AopLocationInit(Student student) {
        this.student = student;
    }

    @Override
    public void run(String... args) throws Exception {
        student.sayHello();

        student.echo("123");
    }


}
