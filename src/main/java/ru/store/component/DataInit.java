package ru.store.component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.store.model.Product;
import ru.store.service.catalog.CatalogService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataInit {

    private static final String pathToCatalog = "src/main/resources/catalog/catalog.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void initCatalog(CatalogService catalogService) {
        File file = new File(pathToCatalog);

        try {

            List<Product> products = mapper.readValue(file, new TypeReference<>() {});

            for (Product product : products) {
                catalogService.addProduct(product);
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
