package ru.store.service.catalog.impl;

import lombok.Data;
import ru.store.enums.Category;
import ru.store.enums.DrinkCategory;
import ru.store.enums.ProductCategory;
import ru.store.enums.ProductType;
import ru.store.model.Product;
import ru.store.service.catalog.CatalogService;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class CatalogServiceImpl implements CatalogService {
    private static CatalogServiceImpl instance;
    Map<Category, List<Product>> productByCategory = new HashMap<>();
    List<Product> allAssortment = new ArrayList<>();


    public static CatalogServiceImpl getInstance() {
        if (instance == null) {
            instance = new CatalogServiceImpl();
        }
        return instance;
    }

    @Override
    public void getProductCatalog() {
        for(ProductCategory productCategory : ProductCategory.values()) {
            System.out.println(productCategory.ordinal() + " : " + productCategory);
        }
    }

    @Override
    public void getDrinkCatalog() {
        for(DrinkCategory drinkCategory : DrinkCategory.values()) {
            System.out.println(drinkCategory.ordinal() + " : " + drinkCategory);
        }
    }

    @Override
    public void addProduct(Product product) {
        allAssortment.add(product);
        Category category = product.getItemType();

        productByCategory.computeIfAbsent(category, k -> new ArrayList<>())
                .add(product);
    }

    @Override
    public void getProductByItemName(int userAnswer) {
        ProductType[] arrayEnum = ProductType.values();

        if (userAnswer >= 0 && userAnswer < arrayEnum.length) {
            ProductType selectedType = arrayEnum[userAnswer];

            List<Product> result = instance.allAssortment.stream()
                    .filter(product -> product.getItemType().equals(selectedType))
                    .toList();

            result.forEach(System.out::println);
        }
    }

    @Override
    public void getDrinktByItemName(int userAnswer) {

    }
}


