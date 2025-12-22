package ru.store.annotation.processor;

import ru.store.component.DataInit;
import ru.store.service.catalog.impl.CatalogServiceImpl;
import ru.store.service.ui.UIService;
import ru.store.service.ui.impl.ManagerUIService;
import ru.store.service.ui.impl.UserUIService;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class CustomAnnotationProcessor {
    public static void processor(Method method, Object[] args) {
        String userType = Arrays.stream((String[]) args[0])
                .filter(it -> it.contains("userType"))
                .map(it -> it.split("=")[1])
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User type not found"));

        CatalogServiceImpl catalogService = CatalogServiceImpl.getInstance();
        DataInit.initCatalog(catalogService);

        Map<String, UIService> services = Map.of(
                "user", new UserUIService(),
                "manager", new ManagerUIService()
        );

        Optional.ofNullable(services.get(userType))
                .orElseThrow(() -> new IllegalArgumentException("Type not supported"))
                .startMenu();
    }
}

