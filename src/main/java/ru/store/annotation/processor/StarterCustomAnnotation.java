package ru.store.annotation.processor;

import ru.store.annotation.CustomAnnotation;

import java.lang.reflect.Method;

public class StarterCustomAnnotation {
    public static void run(Class<?> clazz, String methodName, String[] args) {
        try {
            Method method = clazz.getDeclaredMethod(methodName, String[].class);

            if (!method.isAnnotationPresent(CustomAnnotation.class)) {
                throw new IllegalStateException("Main method must be annotated");
            }

            CustomAnnotationProcessor.processor(method, new Object[]{args});

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
