package softuni;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CachableInvocationHandler implements InvocationHandler {

    private Object realObject;
    private Map<String, Object> cache = new HashMap<>();

    public CachableInvocationHandler(Object realService){
        this.realObject = realService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cachable cachableAnnotation = realObject
                .getClass()
                .getMethod(method.getName(), method.getParameterTypes())
                .getAnnotation(Cachable.class);

        if(cachableAnnotation == null) {
            return method.invoke(realObject, args);
        }else {
            String cacheName = cachableAnnotation.value();
            if(cache.get(cacheName) != null){
                return cache.get(cacheName);
            }else {
                Object result = method.invoke(realObject, args);
                cache.put(cacheName, result);
                return result;
            }
        }
    }
}
