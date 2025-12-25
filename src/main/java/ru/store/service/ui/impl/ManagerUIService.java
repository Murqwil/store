package ru.store.service.ui.impl;

import ru.store.configuration.CatalogGetInstance;
import ru.store.enums.ProductType;
import ru.store.service.catalog.CatalogService;
import ru.store.service.catalog.impl.CatalogServiceImpl;
import ru.store.service.ui.UIService;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManagerUIService implements UIService {
    private static final CatalogService catalogService = CatalogGetInstance.getInstance();
    private final Scanner userAnswer = new Scanner(System.in);

    public Map<Integer, Consumer<Void>> menu = Map.of(
            0, v -> System.exit(0),
            1, v -> getCatalog(),
            2, v -> addProductToStore()
    );

    @Override
    public void startMenu() {
        System.out.println("Меню менеджера: ");
        System.out.println("1. Каталог");
        System.out.println("2. Добавить товар в каталог");
        System.out.println("0. Закрыть");

        menu.get(userAnswer.nextInt()).accept(null);
    }

    public void getCatalog() {
        System.out.println("Выберите категорию: ");
        Map<Integer, ProductType> map =
                IntStream.range(0, ProductType.values().length)
                        .boxed()
                        .collect(Collectors.toMap(
                                i -> i,
                                i -> ProductType.values()[i]
                        ));

        map.forEach((key, value) -> System.out.printf("%d: %s\n", key, value.getProductType()));


        ProductType productType = map.get(userAnswer.nextInt());


        catalogService.getCatalogByProductType(productType);
        System.out.println("Выберите интересующий Вас продукт: ");
        catalogService.getProductsByCategory(productType,userAnswer.nextInt());
        System.out.println("Желаете ли вы что то сделать с данными продуктами?");
        System.out.println("1. Добавить новый товар в каталог");
        System.out.println("0. Вернутся в меню");

        if(userAnswer.nextInt() == 0) {
            startMenu();
        } else {
            addProductToStore();
        }
    }

    public void addProductToStore() {
        System.out.println("Функционал добавить в корзину не реализован!");
    }
}
