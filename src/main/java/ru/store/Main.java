package ru.store;

import ru.store.component.DataInit;
import ru.store.enums.DrinkCategory;
import ru.store.enums.ProductCategory;
import ru.store.model.Product;
import ru.store.service.catalog.impl.CatalogServiceImpl;
import ru.store.service.ui.UIService;
import ru.store.service.ui.impl.ManagerUIService;
import ru.store.service.ui.impl.UserUIService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class Main  {
    static Map<String, UIService> callUserService = Map.of(
            "user", new UserUIService(),
            "manager", new ManagerUIService()
    );

    static CatalogServiceImpl catalogService = new CatalogServiceImpl();

    public static void main(String[] args) {
        String userType = Arrays.stream(args)
                .filter(it -> it.contains("userType"))
                .map(it -> it.split("=")[1]).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User type not found"));

        DataInit.initCatalog(catalogService);

        Optional.ofNullable(callUserService.get(userType))
                .orElseThrow(() -> new IllegalArgumentException("Type not supported"))
                .startMenu();
    }
}

