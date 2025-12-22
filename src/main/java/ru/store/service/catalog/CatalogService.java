package ru.store.service.catalog;

import ru.store.enums.Category;
import ru.store.enums.ProductType;
import ru.store.model.Product;

public interface CatalogService {
    //Получи возможные варианты товаров в магазине
    void getProductProductType();
    void getDrinkProductType();
    void addProduct(Product product);
    //Фильтруй товары по категории
    void getCatalogByProductType(ProductType productType);
    void getProductsByCategory(ProductType productType, int categoryChoice);
    void getAllProducts();

}
