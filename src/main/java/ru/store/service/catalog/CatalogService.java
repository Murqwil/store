package ru.store.service.catalog;

import ru.store.enums.ProductType;
import ru.store.model.Product;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public interface CatalogService {
    void addProduct(Product product);
    void getProductsByCategory(ProductType productType, int categoryChoice);
    void getAllProducts();
    void getCatalogByProductType(ProductType productType);
}
