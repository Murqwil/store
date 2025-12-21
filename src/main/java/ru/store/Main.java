package ru.store;

import ru.store.component.DataInit;
import ru.store.service.catalog.impl.CatalogServiceImpl;
import ru.store.service.ui.UIService;
import ru.store.service.ui.impl.ManagerUIService;
import ru.store.service.ui.impl.UserUIService;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class Main  {
    static Map<String, UIService> callUserService = Map.of(
            "user", new UserUIService(),
            "manager", new ManagerUIService()
    );

    static CatalogServiceImpl catalogService = CatalogServiceImpl.getInstance();

    //Реализовать свою аннотацию которая реализует все ниже перечисленное
    public static void main(String[] args) {
        String userType = Arrays.stream(args)
                .filter(it -> it.contains("userType"))
                .map(it -> it.split("=")[1]).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User type not found"));

        DataInit.initCatalog(catalogService);

        catalogService.getAllAssortment().forEach(System.out::println);

        Optional.ofNullable(callUserService.get(userType))
                .orElseThrow(() -> new IllegalArgumentException("Type not supported"))
                .startMenu();
    }
}

