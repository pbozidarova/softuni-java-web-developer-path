package proxies.cache;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        Object obgToProxy = new StudentServiceImpl();

        StudentService proxiedService = (StudentService) Proxy.newProxyInstance(
                Test.class.getClassLoader(),
                new Class[] { StudentService.class },
                new StudentServiceInvocationHandler(obgToProxy));

        System.out.println(proxiedService.getClass());

        System.out.println(proxiedService.getAllStudents());
        System.out.println(proxiedService.getAllStudents());
    }
}
