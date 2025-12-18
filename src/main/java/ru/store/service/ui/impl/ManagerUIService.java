package ru.store.service.ui.impl;

import ru.store.service.catalog.impl.CatalogServiceImpl;
import ru.store.service.ui.UIService;

public class ManagerUIService implements UIService {
    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();

    @Override
    public void startMenu() {
        System.out.println("Добро пожаловать в магазин продуктов");
        System.out.println();
        System.out.println("Что вы желаете?");
        System.out.println("Меню менеджера: ");
        System.out.println("1. Каталог");
        System.out.println("2. Добавить товар");
        System.out.println("0. Закрыть");

        switch (catalogServiceImpl.getUserAnswer().nextInt()) {
            case 0: System.exit(0);
            case 1:
                System.out.println("Выберите категорию: ");
                System.out.println();
                System.out.println("0: Вода ");
                System.out.println("1: Еда ");

                if (catalogServiceImpl.getUserAnswer().nextInt() == 0) {
                    catalogServiceImpl.getDrinkCatalog();
                    System.out.println("Выберите необходимую категорию: ");
                    catalogServiceImpl.getUserAnswer().nextInt();
                } else {
                    catalogServiceImpl.getProductCatalog();
                    System.out.println("Выберите необходимую категорию: ");
                    catalogServiceImpl.getUserAnswer().nextInt();
                }
                break;
            case 2:
                System.out.println("Функционал еще не реализован!");
                break;
            default:
                System.out.println("Неизвестная команда!");
        }
    }
}
