package ru.store;

import ru.store.enums.DrinkCategory;
import ru.store.enums.ProductCategory;
import ru.store.model.Product;
import ru.store.service.catalog.impl.CatalogServiceImpl;
import ru.store.service.ui.UIService;
import ru.store.service.ui.impl.ManagerUIService;
import ru.store.service.ui.impl.UserUIService;

import java.time.LocalDateTime;

public class Main  {
    static UIService callUserService = new UserUIService();
    static UIService callManagerService = new ManagerUIService();

    static CatalogServiceImpl catalogService = new CatalogServiceImpl();

    public static void main(String[] args) {
        DataInit data = new DataInit();
        catalogService.addProduct(data.product1);
        catalogService.addProduct(data.product2);
        catalogService.addProduct(data.product3);
        catalogService.addProduct(data.product4);
        catalogService.addProduct(data.product5);
//        catalogService.getAllAssortment().forEach(System.out::println);

        callUserService.startMenu();
    }

    static class DataInit {
        Product product1 = new Product("Чеддер",
                249.9F,
                true,
                LocalDateTime.now(), ProductCategory.CHEESE);

        Product product2 = new Product("Моцарелла",
                299.9F,
                true,
                LocalDateTime.now(),
                ProductCategory.CHEESE);

        Product product3 = new Product("Свиная шея",
                349.9F,
                true,
                LocalDateTime.now(), ProductCategory.MEAT);

        Product product4 = new Product("Куринная грудка",
                249.9F,
                true,
                LocalDateTime.now(), ProductCategory.MEAT);


        Product product5 = new Product("Вода обычная",
                59.9F,
                true,
                LocalDateTime.now(), DrinkCategory.NORMAL);
    }
}

