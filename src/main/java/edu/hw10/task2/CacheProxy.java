package edu.hw10.task2;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheProxy implements InvocationHandler {
    private final Map<Method, Map<List<Object>, Object>> cached;
    private final Object obj;

    public CacheProxy(Object object) {
        this.obj = object;
        cached = new HashMap<>();
    }

    public static <T> T create(T instance, Class<?> clazz) {
        return (T) Proxy.newProxyInstance(
            clazz.getClassLoader(),
            clazz.getInterfaces(),
            new CacheProxy(instance)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class)) {
            List<Object> arguments = Arrays.stream(args).toList();

            if (!cached.containsKey(method)) {
                cached.put(method, new HashMap<>());
            }

            if (cached.get(method).containsKey(arguments)) {
                return cached.get(method).get(arguments);
            } else {
                Object result = method.invoke(obj, args);

                cached.get(method).put(arguments, result);

                if (method.getAnnotation(Cache.class).persist()) {
                    try {
                        save(method, arguments, result);
                    } catch (IOException e) {
                    }
                }

                return result;
            }
        }

        return method.invoke(obj, args);
    }

    private void save(Method method, List<Object> argsList, Object result) throws IOException {
        // to implement
    }
}
