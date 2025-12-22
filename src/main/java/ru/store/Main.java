package ru.store;

import ru.store.annotation.CustomAnnotation;
import ru.store.annotation.processor.StarterCustomAnnotation;

public class Main  {
    @CustomAnnotation
    public static void main(String[] args) {
        StarterCustomAnnotation.run(Main.class, "main", args);
    }
}

