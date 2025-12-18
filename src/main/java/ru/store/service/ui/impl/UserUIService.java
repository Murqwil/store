package ru.store.service.ui.impl;

import ru.store.enums.ProductType;
import ru.store.service.catalog.impl.CatalogServiceImpl;
import ru.store.service.ui.UIService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserUIService implements UIService {
    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    public Map<Integer, Consumer<Void>> menu = Map.of(
            0, v -> System.exit(0),
            1, v -> getCatalog(),
            2, v -> addCart()
    );
    Scanner userAnswer = new Scanner(System.in);


    public void startMenu() {
        //Начальное приветствие

        // Вынести в отдельный метод
        System.out.println("Добро пожаловать в магазин продуктов");
        System.out.println();
        System.out.println("Что вы желаете?");
        System.out.println("Пользовательское меню: ");
        System.out.println("1. Каталог");
        System.out.println("2. Добавить в корзину");
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


        catalogServiceImpl.getCatalogByProductType(productType);
    }

    public void addCart() {
        System.out.println("Функционал добавить в корзину не реализован!");
    }

}
