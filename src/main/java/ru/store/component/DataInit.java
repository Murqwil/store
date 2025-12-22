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
            String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));

            if (content.trim().startsWith("[")) {
                List<Product> products = mapper.readValue(
                        file,
                        new TypeReference<List<Product>>() {}
                );

                for (Product product : products) {
                    catalogService.addProduct(product);
                }
            } else if (content.trim().startsWith("{")) {
                Product product = mapper.readValue(file, Product.class);
                catalogService.addProduct(product);
            } else {
                System.err.println("Неверный формат JSON файла");
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
