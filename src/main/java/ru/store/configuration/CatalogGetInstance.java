package ru.store.configuration;

import lombok.Getter;
import ru.store.service.catalog.impl.CatalogServiceImpl;

@Getter
public class CatalogGetInstance {
    private static CatalogServiceImpl instance;

    public static CatalogServiceImpl getInstance() {
        if (instance == null) {
            instance = new CatalogServiceImpl();
        }
        return instance;
    }
}
