package ru.store.service.ui.impl;

import ru.store.service.catalog.impl.CatalogServiceImpl;
import ru.store.service.ui.UIService;

public class UserUIService implements UIService {
    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();

    public void startMenu() {
        //Начальное приветствие
        System.out.println("Добро пожаловать в магазин продуктов");
        System.out.println();
        System.out.println("Что вы желаете?");
        System.out.println("Пользовательское меню: ");
        System.out.println("1. Каталог");
        System.out.println("2. Добавить в корзину");
        System.out.println("0. Закрыть");

        switch (catalogServiceImpl.getUserAnswer().nextInt()) {
            case 0: System.exit(0);

            case 1:
                System.out.println("Выберите категорию: ");
                System.out.println();
                System.out.println("0: Вода ");
                System.out.println("1: Еда ");

                // А если будет категория BBQ или типо того?
                //Тут дыра, если будут новые категории то if else разрастётся...
                if (catalogServiceImpl.getUserAnswer().nextInt() == 0) {
                    catalogServiceImpl.getDrinkCatalog();
                    System.out.println("Выберите необходимую категорию: ");
                    catalogServiceImpl.getDrinktByItemName(catalogServiceImpl.getUserAnswer().nextInt());

                } else {
                    catalogServiceImpl.getProductCatalog();
                    System.out.println("Выберите необходимую категорию: ");
                    catalogServiceImpl.getProductByItemName(catalogServiceImpl.getUserAnswer().nextInt());

                }
                break;

            case 2:
                System.out.println("Функционал добавить в корзину не реализован!");
                break;

            default: System.out.println("Не правильно выбран меню :(");
        }
    }

}
