package ru.store.service.catalog;

import ru.store.enums.Category;
import ru.store.enums.ProductType;
import ru.store.model.Product;

public interface CatalogService {
    //Получи возможные варианты товаров в магазине
    void getProductCatalog();
    void getDrinkCatalog();
    void addProduct(Product product);
    //Фильтруй товары по категории
    void getProductByItemName(int userAnswer);
    void getDrinktByItemName(int userAnswer);
    void getCatalogByProductType(ProductType productType);

}
