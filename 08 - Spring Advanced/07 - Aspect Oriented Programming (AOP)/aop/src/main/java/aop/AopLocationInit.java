package aop;

import aop.model.Student;
import aop.slo.SLOsConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AopLocationInit implements CommandLineRunner {

    private final Student student;
    private final SLOsConfig config;

    public AopLocationInit(Student student, SLOsConfig config) {
        this.student = student;
        this.config = config;
    }

    @Override
    public void run(String... args) throws Exception {
//        student.sayHello();

        student.echo("123");
        System.out.println(config);
    }


}
