package ru.store.service.catalog.impl;

import lombok.Getter;
import ru.store.configuration.CatalogGetInstance;
import ru.store.enums.Category;
import ru.store.enums.DrinkCategory;
import ru.store.enums.ProductCategory;
import ru.store.enums.ProductType;
import ru.store.model.Product;
import ru.store.service.catalog.CatalogService;

import java.util.*;

public class CatalogServiceImpl implements CatalogService {
    private final Map<ProductType, Map<Category, List<Product>>> catalog =  new HashMap<>();
    //Необходимо реализовать методы getter, убрать ломбоковскую часть
    @Getter
    private final List<Product> allAssortment = new ArrayList<>();

    @Getter
    private static final CatalogServiceImpl catalogService = CatalogGetInstance.getInstance();

    @Override
    public void getCatalogByProductType(ProductType productType) {
        if (productType == null) {
            for(DrinkCategory drinkCategory : DrinkCategory.values()) {
                System.out.println(drinkCategory.ordinal() + " : " + drinkCategory);
            }
            for(ProductCategory productCategory : ProductCategory.values()) {
                System.out.println(productCategory.ordinal() + " : " + productCategory);
            }
        } else if (productType == ProductType.DRINK) {
            for(DrinkCategory drinkCategory : DrinkCategory.values()) {
                System.out.println(drinkCategory.ordinal() + " : " + drinkCategory);
            }
        } else {
            for(ProductCategory productCategory : ProductCategory.values()) {
                System.out.println(productCategory.ordinal() + " : " + productCategory);
            }
        }
    }

    @Override
    public void addProduct(Product product) {
        allAssortment.add(product);
        ProductType productType = product.getProductType();
        Category category = product.getCategory();

        catalog.computeIfAbsent(productType, k -> new HashMap<>())
                .computeIfAbsent(category, k -> new ArrayList<>())
                .add(product);
    }

    @Override
    public void getProductsByCategory(ProductType productType, int categoryChoice) {
            Category selectedCategory = productType.getCategoryByIndex(categoryChoice);

            allAssortment.stream()
                    .filter(product -> product.getProductType() == productType)
                    .filter(product -> product.getCategory().equals(selectedCategory))
                    .forEach(System.out::println);
    }


    @Override
    public void getAllProducts() {
        catalogService.getAllAssortment().forEach(System.out::println);
    }
}


