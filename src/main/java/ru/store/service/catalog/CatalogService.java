package ru.store.service.catalog;

import ru.store.enums.ProductType;
import ru.store.model.Product;

public interface CatalogService {
    void getCatalogByProductType(ProductType productType);
    void addProduct(Product product);
    //Фильтруй товары по категории
    void getProductsByCategory(ProductType productType, int categoryChoice);
    void getAllProducts();

}
