package ru.store.component;

import ru.store.service.catalog.CatalogService;

import java.io.File;

public class DataInit {

    private static String pathToCatalog = "";

    public static void initCatalog(CatalogService catalogService) {
        File file = new File(pathToCatalog);
        if (file.exists()) {

        }
    }
}
