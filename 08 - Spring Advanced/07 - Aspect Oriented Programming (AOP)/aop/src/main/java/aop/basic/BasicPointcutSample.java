package aop.basic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class BasicPointcutSample {

    @Pointcut("execution(* aop.model.Student.sayHello())")
    public void trackSayHello(){

    }

//    @Before("trackSayHello()")
    public void logBeforeTheMethod(){
        System.out.println("Before executing of hello!");
    }

//    @After("trackSayHello()")
    public void logAfterTheMethod(){
        System.out.println("After executing say hello!");
    }

    @Around("trackSayHello()")
    public Object logAroundMethodExecution(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Before execution!");
        Object ret = pjp.proceed();

        System.out.println("After execution!");
        return ret;
    }
}
