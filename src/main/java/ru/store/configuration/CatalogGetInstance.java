package ru.store.configuration;

import lombok.Getter;
import ru.store.service.catalog.CatalogService;
import ru.store.service.catalog.impl.CatalogServiceImpl;

@Getter
public class CatalogGetInstance {
    private static volatile CatalogService instance;

    public static synchronized CatalogService getInstance() {
        if (instance == null) {
            instance = new CatalogServiceImpl();
        }
        return instance;
    }
}
